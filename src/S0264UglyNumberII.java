public class S0264UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int f2 = 2, f3 = 3, f5 = 5;
        for (int i = 1; i < n; i++) {
            int m = Math.min(Math.min(f2, f3), f5);
            ugly[i] = m;
            if (f2 == m) {
                f2 = ugly[++i2] * 2;
            }
            if (f3 == m) {
                f3 = ugly[++i3] * 3;
            }
            if (f5 == m) {
                f5 = ugly[++i5] * 5;
            }
        }
        return ugly[n-1];
    }
}
