public class S0125ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder cs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                cs.append(c);
            }
        }
        String cleaned = cs.toString().toLowerCase();
        for (int i = 0, j = cleaned.length()-1; i < j; i++, j--) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
