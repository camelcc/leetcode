public class S0264UglyNumberII {
    public int nthUglyNumber(int n) {
        int c = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i)) {
                c++;
                if (c == n) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("can not find");
    }

    private boolean isUgly(int n) {
        while (n%2 == 0) {
            n = n/2;
        }
        while (n%3 == 0) {
            n = n/3;
        }
        while (n%5 == 0) {
            n = n/5;
        }
        return n == 1;
    }
}
