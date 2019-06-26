public class S0920NumberMusicPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = (int)Math.pow(10, 9)+7;
        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int l = 1; l <= L; l++) {
            for (int j = 1; j <= N; j++) {
                dp[l][j] = dp[l-1][j-1]*(N-(j-1))%MOD;
                if (j > K) {
                    dp[l][j] += dp[l-1][j]*(j-K)%MOD;
                    dp[l][j] = dp[l][j]%MOD;
                }
            }
        }
        return (int)dp[L][N];
    }
}
