public class S2180CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, v = i;
            while (v != 0) {
                sum += v%10;
                v = v/10;
            }
            if (sum%2 == 0) {
                res++;
            }
        }
        return res;
    }
}
