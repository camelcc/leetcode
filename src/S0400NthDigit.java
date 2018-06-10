public class S0400NthDigit {
    public int findNthDigit(int n) {
        long min = 1;
        int digits = 1, size = 9;
        while ((long)n > ((long)digits) * size) {
            n -= digits * size;
            min = 10 * min;
            digits++;
            size = 10 * size;
        }

        long target = min + (n-1)/digits;
        int pos = (n-1)%digits;
        int p = digits - pos - 1;
        while (p > 0) {
            target = target/10;
            p--;
        }
        return (int)target%10;
    }
}
