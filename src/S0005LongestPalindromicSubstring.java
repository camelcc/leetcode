public class S0005LongestPalindromicSubstring {
    int len = 1;
    int start = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length()-1; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start+len);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (len < right-left-1) {
            len = right-left-1;
            start = left+1;
        }
    }
}
