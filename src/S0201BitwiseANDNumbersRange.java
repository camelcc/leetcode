public class S0201BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int diff = n - m + 1;

        int res = 0x0;
        for (int i = 0; i < 31; i++) {
            int and = 0x1 << i;
            if (and <= m && diff <= and && (m & and) != 0 && (n & and) != 0) {
                res = res | and;
            }
        }
        return res;
    }
}
