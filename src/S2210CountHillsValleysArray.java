public class S2210CountHillsValleysArray {
    public int countHillValley(int[] nums) {
        int pre = nums[0], mid = nums[0];
        int res = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            if (mid > pre && mid > nums[i]) {
                res++;
            } else if (mid < pre && mid < nums[i]) {
                res++;
            }
            pre = mid;
            mid = nums[i];
            i++;
        }
        return res;
    }
}
