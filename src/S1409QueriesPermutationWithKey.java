import java.util.HashMap;

public class S1409QueriesPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int[] index = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            index[i] = i+1;
            map.put(i+1, i);
        }
        for (int i = 0; i < queries.length; i++) {
            int v = queries[i];
            int p = map.get(v);
            res[i] = p;
            for (int j = p; j > 0; j--) {
                index[j] = index[j-1];
                map.put(index[j], j);
            }
            map.put(v, 0);
            index[0] = v;
        }
        return res;
    }
}
