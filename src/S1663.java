public class S1663 {
    public String getSmallestString(int n, int k) {
        if (!valid(n, k)) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if (n == 1 && valid(n, k)) {
                res.append((char)('a'+k-1));
                return res.toString();
            }

            // n > 1
            int i = 1;
            while (i <= 26) {
                if (valid(n-1, k-i)) {
                    res.append((char)('a'+i-1));
                    n--;
                    k -= i;
                    break;
                } else {
                    i++;
                }
            }
            if (i > 26) {
                return null;
            }
        }
        return null;
    }

    private boolean valid(int n, int k) {
        if (k <= 0 || n <= 0) {
            return false;
        }
        return k >= n && k <= 26*n;
    }
}
