public class S2172MaximumANDSumArray {
    public int maximumANDSum(int[] nums, int numSlots) {
        int comb = 0x1<<nums.length;
        int[][] dp = new int[numSlots+1][comb];
        return max(nums, numSlots, nums.length,0, dp);
    }

    private int max(int[] nums, int slots, int cnt, int choose, int[][] dp) {
        if (cnt == 0) {
            return 0;
        }
        if (dp[slots][choose] != 0) {
            return dp[slots][choose];
        }
        int res = 0;
        if (cnt <= 2*(slots-1)) {
            res = max(nums, slots-1, cnt, choose, dp);
        }
        if (cnt != 2*slots) {
            for (int i = 0; i < nums.length; i++) {
                if ((choose & (0x1<<i)) != 0) {
                    continue;
                }
                int r = max(nums, slots-1, cnt-1, choose|(0x1<<i), dp);
                res = Math.max(res, (nums[i]&slots)+r);
            }
        }
        for (int first = 0; first < nums.length; first++) {
            if ((choose & (0x1<<first)) != 0) {
                continue;
            }
            for (int second = first+1; second < nums.length; second++) {
                if ((choose & (0x1<<second)) != 0) {
                    continue;
                }
                // choose i & last
                int r = max(nums, slots-1, cnt-2, (choose|(0x1<<first))|(0x1<<second), dp);
                res = Math.max(res, (nums[first]&slots)+(nums[second]&slots)+r);
            }
        }
        dp[slots][choose] = res;
        return res;
    }
}
