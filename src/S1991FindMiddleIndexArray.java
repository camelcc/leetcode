public class S1991FindMiddleIndexArray {
    public int findMiddleIndex(int[] nums) {
        int right = 0;
        for (int n : nums) {
            right += n;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
