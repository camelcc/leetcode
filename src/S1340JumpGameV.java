public class S1340JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, max(arr, d, dp, i));
        }
        return res;
    }

    private int max(int[] arr, int d, int[] dp, int p) {
        if (dp[p] > 0) {
            return dp[p];
        }

        int l = p-1;
        while (l >= 0 && l >= p-d && arr[l] < arr[p]) {
            l--;
        }
        l++;
        int r = p+1;
        while (r < arr.length && r <= p+d && arr[r] < arr[p]) {
            r++;
        }
        r--;

        int res = 1;
        for (int i = l; i <= r; i++) {
            if (i == p) {
                continue;
            }
            res = Math.max(res, 1+max(arr, d, dp, i));
        }
        dp[p] = res;
        return res;
    }
}
