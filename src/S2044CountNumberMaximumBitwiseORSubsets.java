public class S2044CountNumberMaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = max | n;
        }
        int res = 0;
        for (int i = 0; i < (0x1<<nums.length); i++) {
            int v = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i&(0x1<<j)) != 0) {
                    v = v | nums[j];
                }
            }
            if (v == max) {
                res++;
            }
        }
        return res;
    }
}
