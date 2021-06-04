public class S1829MaximumXOREachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int xor = 0;
        for (int n : nums) {
            xor = xor ^ n;
        }
        for (int i = nums.length-1; i >= 0; i--) {
            int k = 0;
            for (int j = 0; j < maximumBit; j++) {
                k = k | ((xor&(0x1<<j)) == 0 ? (0x1<<j) : 0);
            }
            res[nums.length-1-i] = k;
            xor = xor ^ nums[i];
        }
        return res;
    }
}
