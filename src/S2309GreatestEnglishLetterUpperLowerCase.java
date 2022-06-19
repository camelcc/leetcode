public class S2309GreatestEnglishLetterUpperLowerCase {
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        char res = 0;
        for (char c : s.toCharArray()) {
            int i = -1;
            if (c >= 'A' && c <= 'Z') {
                upper[c-'A'] = true;
                i = c-'A';
            } else if (c >= 'a' && c <= 'z') {
                lower[c-'a'] = true;
                i = c-'a';
            }
            if (lower[i] && upper[i] && (char)('A'+i) > res) {
                res = (char) ('A'+i);
            }
        }
        if (res == 0) {
            return "";
        } else {
            return String.valueOf(res);
        }
    }
}
