public class S2103RingsRods {
    public int countPoints(String rings) {
        int[] colors = new int[10];
        for (int i = 0; i < rings.length(); i+=2) {
            char c = rings.charAt(i);
            int p = rings.charAt(i+1)-'0';
            if (c == 'R') {
                colors[p] |= 0x1;
            } else if (c == 'G') {
                colors[p] |= 0x2;
            } else if (c == 'B') {
                colors[p] |= 0x4;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (colors[i] == 7) {
                res++;
            }
        }
        return res;
    }
}
