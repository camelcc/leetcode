public class S0902NumbersMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        if (D.length == 0) {
            return 0;
        }

        int[] cnt = new int[10];
        for (String d : D) {
            int v = Integer.valueOf(d);
            for (int j = v; j < 10; j++) {
                cnt[j]++;
            }
        }
        if (N < 10) {
            return cnt[N];
        }

        int res = 0;
        int c = 1;
        int t = N;
        while (t >= 10) {
            c *= cnt[9];
            res += c;
            t = t/10;
        }
        res += count(String.valueOf(N), cnt);
        return res;
    }

    private int count(String N, int[] digits) {
        if (N.length() == 1) {
            return digits[Integer.valueOf(N)];
        }

        // d.len > 1, d.len-1 > 0
        char[] d = N.toCharArray();
        int f = d[0]-'0';
        if (digits[f] == 0) {
            return 0;
        }

        int cnt = digits[f-1] * (int)Math.pow(digits[9], d.length-1);
        if (digits[f] == digits[f-1]+1) {
            cnt += count(N.substring(1), digits);
        }
        return cnt;
    }
}
