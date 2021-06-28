public class S1910RemoveAllOccurrencesSubstring {
    public String removeOccurrences(String s, String part) {
        int i = 0, p = s.indexOf(part);
        StringBuilder sb = new StringBuilder();
        while (p >= 0 && p < s.length()) {
            sb.append(s.substring(i, p));
            i = p+part.length();
            p = i;
            p = s.indexOf(part, p);
        }
        sb.append(s.substring(i));
        String res = sb.toString();
        if (res.equals(s)) {
            return res;
        } else {
            return removeOccurrences(res, part);
        }
    }
}
