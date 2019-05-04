public class S0214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int pai = s.length()-1;
        while (pai > 0) {
            if (isPalindrome(c, 0, pai)) {
                break;
            }
            pai--;
        }
        StringBuilder sb = new StringBuilder();
        for (pai = pai + 1; pai < s.length(); pai++) {
            sb.insert(0, s.charAt(pai));
        }
        sb.append(s);
        return sb.toString();
    }

    private boolean isPalindrome(char[] s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s[start] != s[end]) {
            return false;
        }
        while (start < end && s[start] == s[end]) {
            start++;
            end--;
        }
        return start >= end;
    }
}
