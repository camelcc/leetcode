import java.util.ArrayList;
import java.util.List;

public class S1434NumberWaysWearDifferentHatsEachOther {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int[] fit = new int[41];
        for (int i = 0; i < n; i++) {
            List<Integer> hat = hats.get(i);
            for (int h : hat) {
                fit[h] = fit[h] | (0x1 << i);
            }
        }
        Integer[][] dp = new Integer[41][1024];
        return ways(fit, n, 1, 0, dp);
    }

    private int ways(int[] fit, int n, int hat, int picked, Integer[][] dp) {
        if (picked == (0x1 << n)-1) {
            return 1;
        }

        if (hat > 40) {
            return 0;
        }
        if (dp[hat][picked] != null) {
            return dp[hat][picked];
        }

        int MOD = (int)(Math.pow(10, 9)+7);

        // nobody wear this hat
        int res = ways(fit, n, hat+1, picked, dp);
        // someone wear this hat
        for (int i = 0; i < n; i++) {
            // this person already wear a hat or hat didn't fit this person
            if ((picked & (0x1 << i)) != 0 || (fit[hat] & (0x1 << i)) == 0) {
                continue;
            }
            long t = ways(fit, n, hat+1, picked|(0x1<<i), dp);
            res = (int)((t+res)%MOD);
        }
        dp[hat][picked] = res;
        return res;
    }
}
