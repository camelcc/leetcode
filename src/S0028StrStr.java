public class S0028StrStr {
    // TODO: KMP and ByoerMoore solution
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }
}
