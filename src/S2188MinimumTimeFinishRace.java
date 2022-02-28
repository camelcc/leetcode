import java.util.Arrays;

public class S2188MinimumTimeFinishRace {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] successive = new int[numLaps+1];
        Arrays.fill(successive, Integer.MAX_VALUE);
        for (int i = 0; i < tires.length; i++) {
            int fi = tires[i][0], ri = tires[i][1];
            int c = fi, l = 1, r = 0;
            while (l <= numLaps && c < fi+changeTime) {
                r += c;
                successive[l] = Math.min(successive[l], r);
                c = c * ri;
                l++;
            }
        }
        int[] dp = new int[numLaps+1];
        return finish(changeTime, numLaps, successive, dp);
    }

    private int finish(int change, int laps, int[] cost, int[] dp) {
        if (laps <= 0) {
            return 0;
        }
        if (dp[laps] != 0) {
            return dp[laps];
        }
        int res = Integer.MAX_VALUE;
        for (int l = 1; l <= laps; l++) {
            if (cost[l] == Integer.MAX_VALUE) {
                continue;
            }
            int r = cost[l] + (l == laps ? 0 : change) + finish(change, laps-l, cost, dp);
            res = Math.min(res, r);
        }
        dp[laps] = res;
        return res;
    }
}
