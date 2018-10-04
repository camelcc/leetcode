public class S0070ClimbingStairs {
    public int climbStairs(int n) {
        assert n > 0;
        if (n <= 2) {
            return n;
        }

        int dp1 = 1;
        int dp2 = 2;
        for (int i = 3; i <= n; i++) {
            int dp = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp2;
    }
}
