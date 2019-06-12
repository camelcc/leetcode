import java.util.ArrayList;
import java.util.List;

public class S0216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return comb(k, n, 1);
    }

    private List<List<Integer>> comb(int k, int n, int v) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k || n > 9*k || v > 9) {
            return res;
        }

        // base
        if (k == 1) {
            if (n >= v && n <= 9) {
                List<Integer> r = new ArrayList<>();
                r.add(n);
                res.add(r);
            }
            return res;
        }

        // k > 1
        for (int i = v; i <= 9; i++) {
            // pick i
            List<List<Integer>> c = comb(k-1, n-i, i+1);
            for (List<Integer> r : c) {
                r.add(0, i);
                res.add(r);
            }
        }
        return res;
    }
}
