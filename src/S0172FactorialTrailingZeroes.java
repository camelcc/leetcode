public class S0172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int twos = 0, fives = 0;
        int t = n;
        while (t >= 2) {
            twos += t/2;
            t = t/2;
        }
        t = n;
        while (t >= 5) {
            fives += t/5;
            t = t/5;
        }
        return Math.min(twos, fives);
    }
}
