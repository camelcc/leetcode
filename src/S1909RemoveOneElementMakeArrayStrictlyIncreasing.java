public class S1909RemoveOneElementMakeArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        boolean exist = false;
        int i = nums.length-1;
        while (i > 0) {
            if (nums[i] > nums[i-1]) {
                i--;
                continue;
            }
            if (exist) {
                return false;
            }
            if (i == 1) {
                return true;
            }
            // i > 1
            if (nums[i] <= nums[i-2]) {
                if (i == nums.length-1 || nums[i+1] > nums[i-1]) {
                    exist = true;
                    i--;
                } else {
                    return false;
                }
            } else {
                exist = true;
                i--;
            }
        }
        return true;
    }
}
