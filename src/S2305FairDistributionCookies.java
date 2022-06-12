public class S2305FairDistributionCookies {
    public int distributeCookies(int[] cookies, int k) {
        int N = 0x1<<cookies.length;
        int[] sum = new int[N];
        for (int assign = 0; assign < N; assign++) {
            int res = 0;
            for (int i = 0; i < cookies.length; i++) {
                if (((0x1 << i) & assign) != 0) {
                    res += cookies[i];
                }
            }
            sum[assign] = res;
        }

        int[][] dp = new int[N][k+1];
        return distribute(cookies, sum, (0x1<<cookies.length)-1, k, dp);
    }

    private int distribute(int[] cookies, int[] sum, int distribute, int k, int[][] dp) {
        assert k != 0;
        if (distribute == 0 || k == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[distribute][k] != 0) {
            return dp[distribute][k];
        }
        if (k == 1) {
            dp[distribute][k] = sum[distribute];
            return dp[distribute][k];
        }

        int res = Integer.MAX_VALUE;
        int N = (0x1<<cookies.length)-1;
        for (int assign = 1; assign < N; assign++) {
            if ((assign | distribute) != distribute) {
                continue;
            }
            int r = distribute(cookies, sum, distribute ^ assign, k-1, dp);
            if (r >= res) {
                continue;
            }

            res = Math.min(res, Math.max(r, sum[assign]));
        }
        dp[distribute][k] = res;
        return res;
    }
}
