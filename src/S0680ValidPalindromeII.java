public class S0680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return validPalidnrome(s, 0, s.length()-1, true);
    }

    private boolean validPalidnrome(String s, int lo, int hi, boolean canDelete) {
        if (lo >= hi) {
            return true;
        }
        if (canDelete) {
            return validPalidnrome(s, lo+1, hi, false) ||
                    validPalidnrome(s, lo, hi-1, false) ||
                    (s.charAt(lo) == s.charAt(hi) &&
                            validPalidnrome(s, lo+1, hi-1, true));
        } else {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            return validPalidnrome(s, lo+1, hi-1, false);
        }
    }
}
