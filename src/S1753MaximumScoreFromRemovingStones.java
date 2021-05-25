public class S1753MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        if (a > b) {
            return maximumScore(b, a, c);
        }
        if (b > c) {
            return maximumScore(a, c, b);
        }
        // a <= b && b <= c
        if (a+b <= c) {
            return a+b;
        }
        // a+b > c
        int res = Math.min(a, a+b-c)/2;
        if (res == 0) {
            return c;
        }
        res = res + maximumScore(a-res, b-res, c);
        return res;
    }
}
