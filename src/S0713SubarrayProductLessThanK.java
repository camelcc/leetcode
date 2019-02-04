public class S0713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = 1;
            for (int j = i; j >= 0 && p < k; j--) {
                p *= nums[j];
                if (p < k) {
                    res++;
                }
            }
        }

        return res;
    }
}
