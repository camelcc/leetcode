public class S1879MinimumXORSumTwoArrays {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        Integer[][] dp  = new Integer[nums1.length][0x1<<nums2.length];
        return sum(nums1, nums2, 0, 0, dp);
    }

    private int sum(int[] num1, int[] num2, int pos1, int picked, Integer[][] dp) {
        if (pos1 == num1.length) {
            return 0;
        }
        if (dp[pos1][picked] != null) {
            return dp[pos1][picked];
        }
        int res = Integer.MAX_VALUE;
        if (pos1 == num1.length-1) {
            for (int i = 0; i < num2.length; i++) {
                if ((picked&(0x1<<i)) != 0) { // picked
                    continue;
                }
                res = Math.min(res, num1[pos1]^num2[i]);
            }
            dp[pos1][picked] = res;
            return res;
        }
        for (int i = 0; i < num2.length; i++) {
            if ((picked&(0x1<<i)) != 0) { // picked
                continue;
            }
            int sum = (num1[pos1]^num2[i]) + sum(num1, num2, pos1+1, picked|(0x1<<i), dp);
            res = Math.min(res, sum);
        }
        dp[pos1][picked] = res;
        return res;
    }
}
