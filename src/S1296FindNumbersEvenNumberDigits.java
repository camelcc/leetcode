public class S1296FindNumbersEvenNumberDigits {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int n : nums) {
            boolean even = (n >= 10 && n < 100) ||
                    (n >= 1000 && n < 10000) || n == 100000;
            if (even) {
                res++;
            }
        }
        return res;
    }
}
