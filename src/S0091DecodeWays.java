public class S0091DecodeWays {
    public int numDecodings(String s) {
        int N = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int c = s.charAt(i)-'0';
            int p = s.charAt(i-1)-'0';
            if (c == 0) {
                if (p != 1 && p != 2) {
                    return 0;
                }
                dp[i] = i > 2 ? dp[i-2] : 1;
            } else {
                dp[i] = dp[i-1];
                int v = 10*p+c;
                if (v >= 10 && v <= 26) {
                    dp[i] += i > 2 ? dp[i-2] : 1;
                }
            }
        }
        return dp[N-1];
    }
}
