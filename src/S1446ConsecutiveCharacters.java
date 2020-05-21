public class S1446ConsecutiveCharacters {
    public int maxPower(String s) {
        int res = 0, len = 0;
        char current = '\0';
        for (char c : s.toCharArray()) {
            if (c == current) {
                len++;
            } else {
                res = Math.max(res, len);
                len = 1;
                current = c;
            }
        }
        res = Math.max(res, len);
        return res;
    }
}
