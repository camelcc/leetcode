public class S1415ThekthLexicographicalStringAllHappyStringsLengthN {
    public String getHappyString(int n, int k) {
        if (n == 1) {
            if (k == 1) {
                return "a";
            } else if (k == 2) {
                return "b";
            } else if (k == 3) {
                return "c";
            } else {
                return "";
            }
        }
        int total = 3*(0x1 << (n-1));
        if (k > total) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char last = '\0';
        int cnt = 0;
        int remains = n;
        while (cnt < k && remains > 0) {
            int c = 0x1 << (remains-1);
            // a
            if (last != 'a') {
                if (cnt + c < k) {
                    cnt += c;
                } else {
                    sb.append('a');
                    last = 'a';
                    remains--;
                    continue;
                }
            }
            if (last != 'b') {
                if (cnt + c < k) {
                    cnt += c;
                } else {
                    sb.append('b');
                    last = 'b';
                    remains--;
                    continue;
                }
            }
            if (last != 'c') {
                assert cnt + c >= k;
                sb.append('c');
                last = 'c';
                remains--;
            }
        }
        return sb.toString();
    }
}
