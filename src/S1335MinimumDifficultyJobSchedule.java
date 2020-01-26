import java.util.Arrays;

public class S1335MinimumDifficultyJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d+1];
        for (int l = 0; l < n; l++) {
            Arrays.fill(dp[l], -1);
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, jobDifficulty[i]);
            dp[i][1] = max;
        }

        return min(jobDifficulty, dp,  n-1, d);
    }

    private int min(int[] difficulty, int[][] dp, int end, int day) {
        assert end+1 >= day;
        if (dp[end][day] != -1) {
            return dp[end][day];
        }

        // day > 1
        assert day > 1;

        int max = difficulty[end];
        int sum = Integer.MAX_VALUE;
        for (int i = end; i >= (day-1); i--) {
            max = Math.max(max, difficulty[i]);
            int s = max + min(difficulty, dp, i-1, day-1);
            if (s < sum) {
                sum = s;
            }
        }

        dp[end][day] = sum;
        return sum;
    }
}
