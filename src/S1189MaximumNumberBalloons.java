public class S1189MaximumNumberBalloons {
    public int maxNumberOfBalloons(String text) {
        int cb = 0, ca = 0, cl = 0, co = 0, cn = 0;
        for (char c : text.toCharArray()) {
            if (c == 'b') {
                cb++;
            } else if (c == 'a') {
                ca++;
            } else if (c == 'l') {
                cl++;
            } else if (c == 'o') {
                co++;
            } else if (c == 'n') {
                cn++;
            }
        }
        cl = cl/2;
        co = co/2;
        return Math.min(cb, Math.min(ca, Math.min(cl, Math.min(co, cn))));
    }
}
