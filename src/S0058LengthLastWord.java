public class S0058LengthLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0, pos = s.length()-1;
        while (pos >= 0 && s.charAt(pos) == ' ') {
            pos--;
        }
        while (pos >= 0 && s.charAt(pos) != ' ') {
            len++;
            pos--;
        }
        return len;
    }
}
