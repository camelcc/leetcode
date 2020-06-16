import java.util.Arrays;

public class S1478AllocateMailboxes {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        Integer[][][] dp = new Integer[houses.length][houses.length][k + 1];
        return min(houses, 0, houses.length - 1, k, dp);
    }

    private int min(int[] houses, int l, int r, int k, Integer[][][] dp) {
        assert k > 0;
        if (l >= r || k >= r-l+1) {
            return 0;
        }
        if (dp[l][r][k] != null) {
            return dp[l][r][k];
        }
        if (k == 1) {
            dp[l][r][k] = min(houses, l, r);
            return dp[l][r][k];
        }

        // l < r, k >= 2
        int res = Integer.MAX_VALUE;
        for (int m = l; m <= r; m++) {
            int d = min(houses, l, m, 1, dp) + min(houses, m+1, r, k-1, dp);
            res = Math.min(res, d);
        }
        dp[l][r][k] = res;
        return res;
    }

    private int min(int[] houses, int l, int r) {
        int res = 0;
        while (l < r) {
            res += houses[r]-houses[l];
            l++;
            r--;
        }
        return res;
    }
}
