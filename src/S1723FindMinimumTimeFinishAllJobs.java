import java.util.Arrays;

public class S1723FindMinimumTimeFinishAllJobs {
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] work = new int[(0x1<<jobs.length)];
        for (int i = 1; i < work.length; i++) {
            int t = 0;
            for (int j = 0; j < jobs.length; j++) {
                if ((i&(0x1<<j)) != 0) {
                    t += jobs[j];
                }
            }
            work[i] = t;
        }
        int[][] dp = new int[work.length][k+1];
        return dfs(work, (0x1<<jobs.length)-1, k, dp);
    }

    private int dfs(int[] work, int jobs, int k, int[][] dp) {
        if (jobs == 0) {
            return 0;
        }
        if (dp[jobs][k] != 0) {
            return dp[jobs][k];
        }
        if (k == 1) {
            dp[jobs][k] = work[jobs];
            return dp[jobs][k];
        }
        // k > 1, jobs > 0
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < work.length; i++) {
            if ((jobs|i) != jobs) { // not a subset
                continue;
            }
            int r = Math.max(work[i], dfs(work, jobs^i, k-1, dp));
            res = Math.min(res, r);
        }
        dp[jobs][k] = res;
        return res;
    }
}
