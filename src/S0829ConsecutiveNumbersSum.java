public class S0829ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; i <= (int)Math.sqrt(2.0*N); i++) {
            int r = N-i*(i+1)/2;
            if (r >= 0 && r%i == 0) {
                res++;
            }
        }
        return res;
    }
}
