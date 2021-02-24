public class S1567MaximumLengthSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int positive = 0, negative = 0;
        for (int n : nums) {
            if (n > 0) {
                positive++;
                if (negative > 0) {
                    negative++;
                }
                res = Math.max(res, positive);
            } else if (n == 0) {
                positive = 0;
                negative = 0;
            } else { // n < 0
                int t = positive;
                if (negative > 0) {
                    positive = negative+1;
                } else {
                    positive = 0;
                }
                negative = t+1;
                res = Math.max(res, positive);
            }
        }
        return res;
    }
}
