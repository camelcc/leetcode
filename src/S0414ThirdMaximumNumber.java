public class S0414ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int max = nums[0];
        Integer secondMax = null;
        Integer thirdMax = null;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (v > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = v;
                continue;
            }
            if (v == max) {
                continue;
            }
            if (secondMax == null) {
                secondMax = v;
                continue;
            }
            if (v > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
                continue;
            }
            if (v == secondMax) {
                continue;
            }
            if (thirdMax == null) {
                thirdMax = v;
                continue;
            }
            if (v > thirdMax) {
                thirdMax = v;
            }
        }
        return thirdMax == null ? max : thirdMax;
    }
}
