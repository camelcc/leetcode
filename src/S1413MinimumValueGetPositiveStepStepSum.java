public class S1413MinimumValueGetPositiveStepStepSum {
    public int minStartValue(int[] nums) {
        int res = 1;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (s < 1) {
                res = Math.max(res, 1-s);
            }
        }
        return res;
    }
}
