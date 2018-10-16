public class S0665NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean canChange = true;
        int pre = Integer.MIN_VALUE;
        int current = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= current) {
                pre = current;
                current = nums[i];
                continue;
            }
            if (!canChange) {
                return false;
            }
            canChange = false;
            if (nums[i] >= pre) {
                current = nums[i];
            }
        }
        return true;
    }
}
