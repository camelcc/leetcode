public class S0303RangeSumQueryImmutable {
    class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length+1];
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                sum[i] = s;
                s += nums[i];
            }
            sum[nums.length] = s;
        }

        public int sumRange(int i, int j) {
            return sum[j+1] - sum[i];
        }
    }
}
