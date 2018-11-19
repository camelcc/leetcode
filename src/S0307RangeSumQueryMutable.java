public class S0307RangeSumQueryMutable {
    public static class NumArray {
        int[] sum;
        int[] num;

        public NumArray(int[] nums) {
            num = nums;
            sum = new int[nums.length];
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                s += nums[i];
                sum[i] = s;
            }
        }

        public void update(int i, int val) {
            int d = val - num[i];
            num[i] = val;
            for (int j = i; j < sum.length; j++) {
                sum[j] = sum[j] + d;
            }
        }

        public int sumRange(int i, int j) {
            int res = sum[j];
            if (i > 0) {
                res -= sum[i-1];
            }
            return res;
        }
    }
}
