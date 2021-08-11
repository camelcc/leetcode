public class S1961CheckStringPrefixArray {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0, p = 0;
        while (i < words.length && p < s.length()) {
            if (!s.startsWith(words[i], p)) {
                return false;
            }
            p = p+words[i].length();
            i++;
        }
        return p == s.length();
    }
}
