import java.util.HashMap;

public class S1155NumberDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        HashMap<Integer, Integer>[] dp = new HashMap[d+1];
        for (int i = 0; i < d+1; i++) {
            dp[i] = new HashMap<>();
        }
        return rolls(d, f, target, dp);
    }

    private int rolls(int d, int f, int target, HashMap<Integer, Integer>[] dp) {
        if (dp[d].containsKey(target)) {
            return dp[d].get(target);
        }
        if (target <= 0 || d <= 0) {
            dp[d].put(target, 0);
            return 0;
        }
        // target > 0 && d > 0
        if (d == 1) {
            int r = target <= f ? 1 : 0;
            dp[d].put(target, r);
            return r;
        }

        // target > 0 && d > 1
        int MOD = (int)Math.pow(10, 9) + 7;
        long cnt = 0;
        for (int roll = 1; roll <= f; roll++) {
            cnt += rolls(d-1, f, target-roll, dp);
        }
        cnt = cnt % MOD;
        dp[d].put(target, (int)cnt);
        return (int)cnt;
    }
}
