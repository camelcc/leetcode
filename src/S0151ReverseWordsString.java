public class S0151ReverseWordsString {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        boolean ignoreWhiteSpace = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (ignoreWhiteSpace) {
                    continue;
                } else {
                    sb.append(c);
                    ignoreWhiteSpace = true;
                }
            } else {
                sb.append(c);
                ignoreWhiteSpace = false;
            }
        }
        if (sb.length() == 0) {
            return sb.toString();
        }

        if (sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }

        String str = sb.toString();
        if (str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            res.append(words[i]).append(" ");
        }
        if (res.charAt(res.length()-1) == ' ') {
            res.deleteCharAt(res.length()-1);
        }
        return res.toString();
    }
}
