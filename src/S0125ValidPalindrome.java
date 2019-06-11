public class S0125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            char lc = s.charAt(lo);
            if ((lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9') || (lc >= 'A' && lc <= 'Z')) {
                if (lc >= 'A' && lc <= 'Z') {
                    lc = (char)(lc-'A'+'a');
                }
            } else {
                lo++;
                continue;
            }
            char hc = s.charAt(hi);
            if ((hc >= 'a' && hc <= 'z') || (hc >= '0' && hc <= '9') || (hc >= 'A' && hc <= 'Z')) {
                if (hc >= 'A' && hc <= 'Z') {
                    hc = (char)(hc-'A'+'a');
                }
            } else {
                hi--;
                continue;
            }
            if (lc != hc) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
