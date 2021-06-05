public class S1844ReplaceAllDigitsCharacters {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2) {
            char c = s.charAt(i);
            sb.append(c);
            if (i == s.length()-1) {
                break;
            }
            sb.append((char)(c+(s.charAt(i+1)-'0')));
        }
        return sb.toString();
    }
}
