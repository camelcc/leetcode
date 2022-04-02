public class S2221FindTriangularSumArray {
    public int triangularSum(int[] nums) {
        int hi = nums.length-1;
        while (hi >= 1) {
            for (int i = 0; i < hi; i++) {
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            hi--;
        }
        return nums[0];
    }
}
