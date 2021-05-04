public class S1688CountMatchesTournament {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 0) {
            if (n == 1) {
                break;
            }
            if (n%2 == 0) {
                res += n/2;
                n = n/2;
            } else {
                res += n/2;
                n = n/2+1;
            }
        }
        return res;
    }
}
