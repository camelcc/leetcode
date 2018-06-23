public class S0029DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }

        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            positive = false;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }

        int count = 0;
        if (dividend == Integer.MIN_VALUE) {
            count++;
            dividend += divisor;
        }
        if (dividend < 0) {
            dividend = -dividend;
        }

        while (dividend >= divisor) {
            int d = divisor;
            int c = 1;
            while (dividend >= d) {
                count += c;
                dividend -= d;
                if (Integer.MAX_VALUE - d < d) {
                    break;
                }
                d = d + d;
                c = c + c;
            }
        }

        return positive ? count : -count;
    }
}
