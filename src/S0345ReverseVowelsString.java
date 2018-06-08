public class S0345ReverseVowelsString {
    public String reverseVowels(String s) {
        char[] r = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            r[i] = s.charAt(i);
        }
        int lo = 0, hi = r.length-1;
        while (lo < hi) {
            if (!isVowel(r[lo])) {
                lo++;
                continue;
            }
            if (!isVowel(r[hi])) {
                hi--;
                continue;
            }

            char t = r[lo];
            r[lo] = r[hi];
            r[hi] = t;
            lo++;
            hi--;
        }
        return String.valueOf(r);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
