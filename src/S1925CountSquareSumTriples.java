public class S1925CountSquareSumTriples {
    public int countTriples(int n) {
        int res = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a; b < n; b++) {
                int s = a*a+b*b;
                if (s > n*n) {
                    break;
                }
                int root = (int)Math.sqrt(s);
                if (root*root == s) {
                    res += a == b ? 1 : 2;
                }
            }
        }
        return res;
    }
}
