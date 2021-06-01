import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1803CountPairsWithXORRange {
    static class Trie {
        Trie[] t = new Trie[2];
        int cnt = 0;

        void insert(int a, int i) {
            if (i >= 0) {
                int A = (a >> i) & 1;
                t[A] = t[A] == null ? new Trie() : t[A];
                t[A].cnt++;
                t[A].insert(a, i - 1);
            }
        }

        /*
          Tire  A  xor    X
          -------------------------------------------
           1    1   0     1  nice pairs exits
           0    0   0     1  nice pairs exits

           0    1   1     1  go ahead
           1    0   1     1  go ahead
           1    1   0     0  go ahead
           0    0   0     0  go ahead

           0    1   1     0  no nice pairs, ignorable.
           1    0   1     0  no nice pairs, ignorable.
          -------------------------------------------

         Also need check if current Trie has 0-bit/1-bit sub branch
        */
        int nicePairsLessThan(int a, int x, int i) {
            int A = a >> i & 1, X = x >> i & 1;
            int nicePairs = X == 1 ? (t[A] != null ? t[A].cnt : 0) : 0;
            return nicePairs + (t[A ^ X] != null ? t[A ^ X].nicePairsLessThan(a, x, i - 1) : 0);
        }
    }

    static int countPairs(int[] nums, int low, int high) {
        int max = Math.max(Math.max(Arrays.stream(nums).max().getAsInt(), low), high + 1);
        int d = (int) (Math.log(max) / (Math.log(2))); // Depth of Tries

        Trie tries = new Trie();
        int r = 0;
        for (int a : nums) {
            r += tries.nicePairsLessThan(a, high + 1, d) - tries.nicePairsLessThan(a, low, d);
            tries.insert(a, d);
        }
        return r;
    }

    // Solution with map ---------------------------------------------------------
    public static int countPairs2(int[] nums, int low, int high) {
        return countsLessThan(nums, high + 1) - countsLessThan(nums, low);
    }

    private static int countsLessThan(int[] nums, int x) {
        Map<Integer, Integer> m = new HashMap<>(), m2;
        for (int n : nums) m.put(n, m.getOrDefault(n, 0) + 1);
        int r = 0;
        while (x > 0) {
            m2 = new HashMap<>();
            for (int a : m.keySet()) {
                int counts = m.get(a), b = (x - 1) ^ a;
                if ((x & 1) == 1) r += counts * m.getOrDefault(b, 0);
                m2.put(a >> 1, m2.getOrDefault(a >> 1, 0) + counts);
            }
            m = m2;
            x >>= 1;
        }
        return r / 2;
    }
}
