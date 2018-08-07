public class S0279PerfectSquares {
    public int numSquares(int n) {
        return squares(n, (int)Math.sqrt(n));
    }

    private int squares(int n, int max) {
        int maxSquare = Math.min((int)Math.sqrt(n), max);
        if (maxSquare == 1) {
            return n;
        }
        if (maxSquare * maxSquare == n) {
            return 1;
        }

        int sqs = n;
        for (int i = maxSquare; i >= 1; i--) {
            int s = squares(n-i*i, i);
            if (s < sqs) {
                sqs = s;
            }
        }
        return sqs+1;
    }
}
