import java.util.*;

public class S1202SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int rl = root(parent, pair.get(0));
            int rr = root(parent, pair.get(1));
            if (rl < rr) {
                parent[rr] = rl;
            } else if (rl > rr) {
                parent[rl] = rr;
            }
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i] = root(parent, i);
        }

        HashMap<Integer, List<Character>> sb = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            sb.putIfAbsent(parent[i], new ArrayList<>());
            sb.get(parent[i]).add(s.charAt(i));
        }
        for (int r : sb.keySet()) {
            Collections.sort(sb.get(r));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < parent.length; i++) {
            res.append(sb.get(parent[i]).remove(0));
        }
        return res.toString();
    }

    private int root(int[] parent, int p) {
        int r = p;
        while (parent[r] != r) {
            r = parent[r];
        }
        return r;
    }
}
