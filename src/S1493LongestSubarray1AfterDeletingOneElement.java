public class S1493LongestSubarray1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i] == 1 ? pre[i-1]+1 : 0;
        }
        int[] sur = new int[nums.length+1];
        sur[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            sur[i] = nums[i] == 1 ? sur[i+1]+1 : 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, (i > 0 ? pre[i-1] : 0) + (i < nums.length-1 ? sur[i+1] : 0));
        }
        return res;
    }
}
