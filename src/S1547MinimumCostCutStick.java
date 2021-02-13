import java.util.Arrays;

public class S1547MinimumCostCutStick {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] segs = new int[cuts.length+2];
        for (int i = 0; i < cuts.length; i++) {
            segs[i+1] = cuts[i];
        }
        segs[cuts.length+1] = n;
        Integer[][] dp = new Integer[cuts.length+2][cuts.length+2];
        return dp(segs, 0, cuts.length+1, dp);
    }

    private int dp(int[] cuts, int start, int end, Integer[][] dp) {
        if (start >= end) {
            return 0;
        }
        if (start+1 == end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int res = cuts[end]-cuts[start]; // len
        int cost = Integer.MAX_VALUE;
        for (int i = start+1; i < end; i++) {
            int t = dp(cuts, start, i, dp) + dp(cuts, i, end, dp);
            cost = Math.min(cost, t);
        }
        res += cost;

        dp[start][end] = res;
        return res;
    }
}
