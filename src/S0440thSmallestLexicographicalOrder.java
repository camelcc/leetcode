public class S0440thSmallestLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        if (n < 10) {
            return k;
        }
        int current = 1;
        k--;
        while (k > 0) {
            int steps = steps(n, current, current+1);
            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }
        return current;
    }

    private int steps(int num, long current, long next) {
        int cnt = 0;
        while (current <= num) {
            cnt += Math.min(num+1, next) - current;
            current *= 10;
            next *= 10;
        }
        return cnt;
    }
}
