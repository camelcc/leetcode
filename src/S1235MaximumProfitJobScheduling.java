import java.util.Arrays;
import java.util.Comparator;

public class S1235MaximumProfitJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        int last = jobs[jobs.length-1][2];
        int[] dp = new int[jobs.length];
        dp[jobs.length-1] = last;

        for (int i = jobs.length-2; i >= 0; i--) {
            int p = jobs[i][2];
            // starttime >= jobs[i][1];
            int t = jobs[i][1];
            if (jobs[jobs.length-1][0] >= t) {
                int left = i+1, right = jobs.length-1;
                while (left < right) {
                    int mid = left + (right-left)/2;
                    if (jobs[mid][0] < t) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                p += dp[left];
            }
            dp[i] = Math.max(dp[i+1], p);
        }
        return dp[0];
    }
}
