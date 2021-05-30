import java.util.ArrayList;
import java.util.List;

public class S1799MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                candidates.add(new int[]{(0x1<<i)|(0x1<<j), gcd(nums[i], nums[j])});
            }
        }
        int cur = 0, n = nums.length/2;
        int[][] dp = new int[0x1<<nums.length][n+1];
        return max(candidates, cur, n, dp);
    }

    private int max(List<int[]> candidates, int cur, int n, int[][] dp) {
        if (dp[cur][n] != 0) {
            return dp[cur][n];
        }
        int res = 0;
        if (n == 1) {
            for (int[] can : candidates) {
                if ((can[0]&cur) != 0) {
                    continue;
                }
                res = Math.max(res, can[1]);
            }
            dp[cur][n] = res;
            return res;
        }
        for (int[] can : candidates) {
            if ((can[0]&cur) != 0) {
                continue;
            }
            res = Math.max(res, n*can[1]+max(candidates, cur|can[0], n-1, dp));
        }
        dp[cur][n] = res;
        return res;
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
