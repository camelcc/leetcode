public class S0633SumSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        int b = 0;
        while (b <= sqrt) {
            int r = c - b*b;
            int s = (int)Math.sqrt(r);
            if (s*s == r) {
                return true;
            } else {
                b++;
            }
        }
        return false;
    }
}
