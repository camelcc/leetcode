public class S0917ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int lo = 0, hi = S.length()-1;
        char[] res = S.toCharArray();
        while (lo < hi) {
            while (lo < S.length() &&
                    !((res[lo] >= 'a' && res[lo] <= 'z') ||
                            (res[lo] >= 'A' && res[lo] <= 'Z'))) {
                lo++;
            }
            while (hi >= 0 &&
                    !((res[hi] >= 'A' && res[hi] <= 'Z') ||
                            (res[hi] >= 'a' && res[hi] <= 'z'))) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            char t = res[lo];
            res[lo] = res[hi];
            res[hi] = t;
            lo++;
            hi--;
        }
        return new String(res);
    }
}
