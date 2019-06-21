public class S0903ValidPermutationsforDISequence {

    public int numPermsDISequence(String S) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int len = S.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                int count = 0;
                for (int j = 0; j < len-i; j++) {
                    count += dp[i][j];
                    count = count%MOD;
                    dp[i+1][j] = count;
                }
            } else { // D
                int count = 0;
                for (int j = len-i-1; j >= 0; j--) {
                    count += dp[i][j+1];
                    count = count%MOD;
                    dp[i+1][j] = count;
                }
            }
        }

        return dp[len][0];
    }
}
