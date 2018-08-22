public class S0397IntegerReplacement {
    public int integerReplacement(int n) {
        return count(n);
    }

    private int count(long n) {
        int steps = 0;
        while ((n & 0x1) == 0) {
            n = n >> 1;
            steps++;
        }
        if (n == 1) {
            return steps;
        }

        // 1XXX1
        steps++;
        return Math.min(count(n + 1), count(n - 1)) + steps;
    }
}
