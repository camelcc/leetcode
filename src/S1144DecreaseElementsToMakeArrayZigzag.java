public class S1144DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = Integer.MAX_VALUE;
            if (i > 0) {
                m = Math.min(m, nums[i-1]);
            }
            if (i < nums.length-1) {
                m = Math.min(m, nums[i+1]);
            }
            int s = nums[i] < m ? 0 : nums[i]-m+1;
            if (i%2 == 0) {
                even += s;
            } else {
                odd += s;
            }
        }
        return Math.min(even, odd);
    }
}
