public class S0164MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        for (int i = 0; i < 32; i++) {
            int[] t = new int[nums.length];
            int p = 0;
            int mask = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) == 0) {
                    t[p++] = nums[j];
                }
            }
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) {
                    t[p++] = nums[j];
                }
            }
            nums = t;
        }

        int gap = nums[1]-nums[0];
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i]-nums[i-1]);
        }
        return gap;
    }
}
