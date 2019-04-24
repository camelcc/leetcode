public class S0041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (!(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length)) {
                int t = nums[i];
                if (nums[t-1] == t) {
                    nums[i] = 0;
                } else {
                    nums[i] = nums[t - 1];
                    nums[t - 1] = t;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
