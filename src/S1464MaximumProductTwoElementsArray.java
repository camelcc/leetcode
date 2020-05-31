public class S1464MaximumProductTwoElementsArray {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v >= max1) {
                max2 = max1;
                max1 = v;
            } else if (v >= max2) {
                max2 = v;
            }
        }
        return (max1-1)*(max2-1);
    }
}
