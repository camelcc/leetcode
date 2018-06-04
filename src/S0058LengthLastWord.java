public class S0058LengthLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }
}
