import java.util.ArrayList;
import java.util.List;

public class S1627GraphConnectivityWithThreshold {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        if (threshold == 0) {
            for (int i = 0; i < queries.length; i++) {
                res.add(true);
            }
            return res;
        }
        int[] root = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            root[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++){
            for (int j = i * 2; j <= n; j += i){
                int r1 = root(root, i), r2 = root(root, j);
                if(r1 == r2){
                    continue;
                }
                if (r1 < r2) {
                    root[r2] = r1;
                } else {
                    root[r1] = r2;
                }
            }
        }
        for(int[] q : queries){
            res.add(root(root, q[0]) == root(root, q[1]));
        }
        return res;
    }

    private int root(int[] root, int i) {
        if (root[i] != i) {
            root[i] = root(root, root[i]);
        }
        return root[i];
    }
}
