// https://leetcode.com/problems/minimum-skips-to-arrive-at-meeting-on-time/discuss/1239838/JavaC%2B%2BPython-DP-Solution
public class S1883MinimumSkipsArriveMeetingOnTime {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length, dp[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = n; j >= 0; --j) {
                dp[j] += dist[i];
                if (i < n - 1)
                    dp[j] = (dp[j] + speed - 1) / speed * speed; // take a rest
                if (j > 0)
                    dp[j] = Math.min(dp[j], dp[j - 1] + dist[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dp[i] <= (long)speed * hoursBefore)
                return i;
        }
        return -1;
    }
}
