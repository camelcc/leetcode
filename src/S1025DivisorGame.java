public class S1025DivisorGame {
    public boolean divisorGame(int N) {
        return divisor(N, new Boolean[1001]);
    }

    private boolean divisor(int v, Boolean[] dp) {
        if (dp[v] != null) {
            return dp[v];
        }
        for (int i = 1; i <= v/2; i++) {
            if (v%i != 0) {
                continue;
            }
            if (!divisor(v-i, dp)) {
                dp[v] = true;
                return true;
            }
        }
        dp[v] = false;
        return false;
    }
}
