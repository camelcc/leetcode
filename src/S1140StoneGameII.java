import java.util.HashMap;

public class S1140StoneGameII {
    public int stoneGameII(int[] piles) {
        HashMap<Integer, Integer>[] dp = new HashMap[piles.length];
        int[] sum = new int[piles.length+1];
        for (int i = 0; i < piles.length; i++) {
            dp[i] = new HashMap<>();
            sum[i+1] = piles[i] + sum[i];
        }
        return max(piles, sum, 0, 1, dp);
    }

    private int max(int[] piles, int[] sum, int pos, int m, HashMap<Integer, Integer>[] dp) {
        if (dp[pos].containsKey(m)) {
            return dp[pos].get(m);
        }
        if (pos+2*m >= piles.length) {
            dp[pos].put(m, sum[piles.length]-sum[pos]);
            return dp[pos].get(m);
        }
        int res = 0;
        int remains = sum[piles.length]-sum[pos];
        for (int x = 1; x <= 2*m; x++) {
            int np = pos+x;
            int nm = Math.max(m, x);
            res = Math.max(res, remains-max(piles, sum, np, nm, dp));
        }
        dp[pos].put(m, res);
        return res;
    }
}
