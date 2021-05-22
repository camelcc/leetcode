public class S1736LatestTimeReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] c = time.toCharArray();
        if (c[0] == '?') {
            if (c[1] == '?') {
                c[0] = '2';
                c[1] = '3';
            } else {
                c[0] = c[1] < '4' ? '2' : '1';
            }
        } else {
            if (c[1] == '?') {
                c[1] = c[0] == '2' ? '3' : '9';
            }
        }
        if (c[3] == '?') {
            c[3] = '5';
        }
        if (c[4] == '?') {
            c[4] = '9';
        }
        return new String(c);
    }
}
