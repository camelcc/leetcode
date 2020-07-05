public class S1505MinimumPossibleIntegerAfterMostKAdjacentSwapsOnDigits {
    public String minInteger(String num, int k) {
        char[] c = num.toCharArray();
        int i = 0;
        while (i < num.length() && k > 0) {
            int mi = i, t = mi;
            while (t < Math.min(i+k+1, num.length())) {
                if (c[mi] > c[t]) {
                    mi = t;
                }
                t++;
            }
            k -= mi-i;
            char mc = c[mi];
            while (mi > i) {
                c[mi] = c[mi-1];
                mi--;
            }
            c[i] = mc;
            i++;
        }
        return new String(c);
    }
}
