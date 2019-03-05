public class S0795NumberSubarraysBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A.length == 0) {
            return 0;
        }

        int res = 0;
        int[] dp = new int[A.length];
        if (A[0] >= L && A[0] <= R) {
            dp[0] = 1;
            res += 1;
        } else {
            dp[0] = 0;
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] < L) {
                dp[i] = dp[i-1];
            } else if (A[i] >= L && A[i] <= R) {
                int cnt = 1;
                for (int j = i-1; j >= 0 && A[j] <= R; j--) {
                    cnt++;
                }
                dp[i] = cnt;
            } else {
                dp[i] = 0;
            }
            res += dp[i];
        }

        return res;
    }
}
