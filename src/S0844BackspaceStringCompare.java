public class S0844BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int si = S.length()-1;
        int sd = 0;
        int ti = T.length()-1;
        int td = 0;

        while (ti >= 0 || si >= 0) {
            char cs = '\0';
            while (si >= 0) {
                char c = S.charAt(si--);
                if (c == '#') {
                    sd++;
                    continue;
                }
                if (sd > 0) {
                    sd--;
                    continue;
                }

                cs = c;
                break;
            }
            char ct = '\0';
            while (ti >= 0) {
                char c = T.charAt(ti--);
                if (c == '#') {
                    td++;
                    continue;
                }
                if (td > 0) {
                    td--;
                    continue;
                }

                ct = c;
                break;
            }
            if (cs != ct) {
                return false;
            }
        }
        return true;
    }
}
