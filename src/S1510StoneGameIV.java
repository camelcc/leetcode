public class S1510StoneGameIV {
    public boolean winnerSquareGame(int n) {
        Boolean[] winner = new Boolean[n+1];
        int i = 1;
        while (i*i <= n) {
            winner[i*i] = true;
            i++;
        }
        return winner(n, winner);
    }

    private boolean winner(int n, Boolean[] dp) {
        if (dp[n] != null) {
            return dp[n];
        }

        boolean res = false;
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if (!winner(n-i*i, dp)) {
                res = true;
                break;
            }
        }
        dp[n] = res;
        return res;
    }
}
