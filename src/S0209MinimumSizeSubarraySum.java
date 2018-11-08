public class S0209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0, sum = 0, len = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];

            while (sum >= s) {
                int l = right-left;
                len = Math.min(len, l);
                sum -= nums[left];
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
