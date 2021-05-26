public class S1763LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int[] upper = new int[s.length()];
        int[] lower = new int[s.length()];
        int len = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lower[i] = 0x1 << (c-'a');
            } else if (c >= 'A' && c <= 'Z') {
                upper[i] = 0x1 << (c-'A');
            }
            for (int j = 0; j < i; j++) {
                upper[j] = upper[j] | upper[i];
                lower[j] = lower[j] | lower[i];
                if ((upper[j] ^ lower[j]) == 0 && (i-j+1) > len) { // nice
                    len = i-j+1;
                    res = s.substring(j, i+1);
                }
            }
        }
        return res;
    }
}
