public class S2256MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long post = 0;
        for (int n : nums) {
            post += n;
        }
        int res = 0;
        long diff = Long.MAX_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev += nums[i];
            post -= nums[i];

            long d = Math.abs(prev/(i+1)- (i == nums.length -1 ? 0 : (post/(nums.length-i-1))));
            if (d < diff) {
                diff = d;
                res = i;
            }
        }
        return res;
    }
}
