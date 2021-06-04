public class S1827MinimumOperationsMakeArrayIncreasing {
    public int minOperations(int[] nums) {
        int res = 0, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > cur) {
                cur = nums[i];
            } else {
                res += cur+1-nums[i];
                cur++;
            }
        }
        return res;
    }
}
