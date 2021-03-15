public class S1592RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int wc = 0, sc = 0;
        boolean word = false;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sc++;
                if (word) {
                    wc++;
                    word = false;
                }
            } else {
                word = true;
            }
        }
        if (word) {
            wc++;
        }
        int rc = wc == 1 ? sc : sc%(wc-1);
        int dc = wc == 1 ? 0 : sc/(wc-1);
        StringBuilder sb = new StringBuilder();
        word = false;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (word) {
                    wc--;
                }
                if (word && wc > 0) {
                    for (int i = 0; i < dc; i++) {
                        sb.append(' ');
                    }
                }
                word = false;
            } else {
                sb.append(c);
                word = true;
            }
        }
        for (int i = 0; i < rc; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
