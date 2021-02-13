public class S1544MakeTheStringGreat {
    public String makeGood(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char p = '\0';
        for (char c : s.toCharArray()) {
            if (p != c && Character.toLowerCase(p) == Character.toLowerCase(c)) {
                p = '\0';
            } else {
                if (p != '\0') {
                    sb.append(p);
                }
                p = c;
            }
        }
        if (p != '\0') {
            sb.append(p);
        }
        if (sb.length() == s.length()) {
            return s;
        } else {
            return makeGood(sb.toString());
        }
    }
}
