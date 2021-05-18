public class S1718ConstructLexicographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        dfs(res, 0, new boolean[n]);
        return res;
    }

    private boolean dfs(int[] res, int p, boolean[] picked) {
        if (p == res.length) {
            return true;
        }
        assert(res[p] == 0);
        for (int v = picked.length-1; v >= 0; v--) {
            if (picked[v] || (v > 0 && (p+v+1 >= res.length || res[p+v+1] != 0))) {
                continue;
            }
            res[p] = v+1;
            if (v != 0) {
                res[p+v+1] = v+1;
            }
            picked[v] = true;
            int np = p+1;
            while (np < res.length && res[np] != 0) {
                np++;
            }
            if (dfs(res, np, picked)) {
                return true;
            }
            picked[v] = false;
            res[p] = 0;
            if (v != 0) {
                res[p+v+1] = 0;
            }
        }
        return false;
    }
}
