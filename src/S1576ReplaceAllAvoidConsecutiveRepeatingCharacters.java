public class S1576ReplaceAllAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char prev = '\0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '?') {
                prev = c;
                sb.append(c);
            } else {
                for (char ch : chars) {
                    if (ch == prev) {
                        continue;
                    }
                    if (i < s.length()-1 && ch == s.charAt(i+1)) {
                        continue;
                    }
                    prev = ch;
                    sb.append(ch);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
