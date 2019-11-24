import java.util.HashMap;

public class S1269NumberWaysStaySamePlaceAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        HashMap<Integer, Integer>[] dp = new HashMap[steps+1];
        for (int i = 0; i < steps+1; i++) {
            dp[i] = new HashMap<>();
        }
        return dp(0, steps, arrLen, dp);
    }

    private int dp(int pos, int steps, int arrLen, HashMap<Integer, Integer>[] dp) {
        if (steps == 0) {
            return pos == 0 ? 1 : 0;
        }
        int MOD = (int)Math.pow(10, 9) + 7;
        if (dp[steps].containsKey(pos)) {
            return dp[steps].get(pos);
        }
        // steps > 1
        long stay = dp(pos, steps-1, arrLen, dp);
        long left = 0;
        if (pos > 0) {
            left = dp(pos-1, steps-1, arrLen, dp);
        }
        long right = 0;
        if (pos < arrLen-1) {
            right = dp(pos+1, steps-1, arrLen, dp);
        }
        long r = (stay+left+right)%MOD;
        dp[steps].put(pos, (int)r);
        return (int)r;
    }
}
