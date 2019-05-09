import java.util.Arrays;
import java.util.Comparator;

public class S0354RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }

        // sort by area descendant
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]*o2[1]-o1[0]*o1[1];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            res = Math.max(res, max(envelopes, dp, i));
        }
        return res;
    }

    private int max(int[][] envelops, int[] dp, int index) {
        if (dp[index] != 0) {
            return dp[index];
        }

        int res = 1;
        for (int i = index+1; i < envelops.length; i++) {
            if (envelops[i][0] < envelops[index][0] && envelops[i][1] < envelops[index][1]) {
                res = Math.max(res, 1+max(envelops, dp, i));
            }
        }

        dp[index] = res;
        return res;
    }
}
