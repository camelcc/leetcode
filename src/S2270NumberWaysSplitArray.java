public class S2270NumberWaysSplitArray {
    public int waysToSplitArray(int[] nums) {
        long total = 0000;
        for (int n : nums) {
            total += n;
        }
        int res = 0;
        long right = 0;
        for (int i = nums.length-1; i > 0; i--) {
            right += nums[i];
            if (total-right >= right) {
                res++;
            }
        }
        return res;
    }
}
