import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class S2157GroupsStrings {
    private static class UF {
        int[] root;
        int[] size;

        public UF(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        void connect(int x, int y) {
            int rx = root(x);
            int ry = root(y);
            if (rx != ry) {
                root[ry] = rx;
                size[rx] += size[ry];
            }
        }

        int root(int x) {
            if (root[x] == x) {
                return x;
            }
            root[x] = root(root[x]);
            return root[x];
        }
    }


    public int[] groupStrings(String[] words) {
        // reverse index, val -> index
        HashMap<Integer, Integer> ri = new HashMap<>();
        int[] wv = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wv[i] = val(words[i]);
            ri.put(wv[i], i);
        }

        int N = words.length;
        UF uf = new UF(N);

        for (int i = 0; i < N; i++) {
            int v = val(words[i]);

            for (int adj : connected(v)) {
                if (ri.containsKey(adj)) {
                    int ai = ri.get(adj);
                    uf.connect(i, ai);
                }
            }
        }
        HashSet<Integer> groups = new HashSet<>();
        int ms = 0;
        for (int i = 0; i < N; i++) {
            int r = uf.root(i);
            groups.add(r);
            ms = Math.max(ms, uf.size[r]);
        }
        return new int[]{groups.size(), ms};
    }

    private int val(String word) {
        int v = 0;
        for (char c : word.toCharArray()) {
            v = v | (0x1<<(c-'a'));
        }
        return v;
    }

    private HashSet<Integer> connected(int v) {
        HashSet<Integer> res = new HashSet<>();
        res.add(v);
        for (int i = 0; i < 26; i++) {
            res.add(v ^ (0x1<<i));
            if ((v & (0x1<<i)) != 0) {
                for (int j = 0; j < 26; j++) {
                    if ((v & (0x1<<j)) == 0) {
                        res.add(v^(0x1<<i)^(0x1<<j));
                    }
                }
            }
        }
        return res;
    }
}
