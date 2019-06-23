public class S0906SuperPalindromes {
    public int superpalindromesInRange(String L, String R) {
        long lo = (long)Math.sqrt(Long.valueOf(L)), hi = (long)Math.sqrt(Long.valueOf(R));
        int cnt = 0;
        long i = lo;
        while (i <= hi) {
            long n = next(i);
            if (n > hi) {
                break;
            }
            if (isPalindrome(String.valueOf(n*n))) {
                cnt++;
            }
            i = n+1;
        }
        return cnt;
    }

    private long next(long v) {
        if (v <= 9) {
            return v;
        }

        // d.len >= 2
        String d = String.valueOf(v);
        if (isPalindrome(d)) {
            return v;
        }
        boolean even = d.length()%2 == 0;
        String h = d.substring(0, (d.length()+1)/2);
        String t = h + new StringBuilder(h).reverse().substring(even ? 0 : 1);
        if (Long.valueOf(t) > v) {
            return Long.valueOf(t);
        }
        t = String.valueOf(Long.valueOf(h)+1);
        if (t.length() == h.length()+1) {
            t = t + new StringBuilder(t).reverse().substring(even ? 1 : 2);
        } else {
            t = t + new StringBuilder(t).reverse().substring(even ? 0 : 1);
        }
        return Long.valueOf(t);
    }

    private boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
