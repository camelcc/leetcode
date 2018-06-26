public class S0060PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        char[] c = new char[n];
        for (int i = 1; i <= n; i++) {
            c[i-1] = (char)('0' + i);
        }
        return getPermutation(c, k-1);
    }

    private String getPermutation(char[] chars, int k) {
        if (chars.length == 0) {
            return "";
        }
        if (chars.length == 1) {
            return String.valueOf(chars[0]);
        }

        int m = mul(chars.length - 1);
        for (int i = 0; i < chars.length; i++) {
            int lo = i * m;
            int hi = (i+1) * m - 1;
            if (k >= lo && k <= hi) {
                return String.valueOf(chars[i]) + getPermutation(remove(chars, i), k-lo);
            }
        }
        throw new IllegalArgumentException("invalid k");
    }

    private char[] remove(char[] chars, int p) {
        char[] remains = new char[chars.length-1];
        for (int i = 0, w = 0; i < chars.length; i++) {
            if (i == p) {
                continue;
            }
            remains[w++] = chars[i];
        }
        return remains;
    }

    private int mul(int n) {
        int res = 1;
        while (n > 1) {
            res = res * n--;
        }
        return res;
    }
}
