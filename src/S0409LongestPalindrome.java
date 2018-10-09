public class S0409LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c - 'A']++;
            }
        }
        boolean single = false;
        int len = 0;
        for (int i = 0; i < 26; i++) {
            len += lower[i];
            if (lower[i] % 2 != 0) {
                len--;
                single = true;
            }

            len += upper[i];
            if (upper[i] % 2 != 0) {
                len--;
                single = true;
            }
        }
        return len + (single ? 1 : 0);
    }
}
