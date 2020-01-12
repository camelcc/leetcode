public class S1318MinimumFlipsMakeaORbEqualc {
    public int minFlips(int a, int b, int c) {
        int res = 0;

        while (a != 0 || b != 0 || c != 0) {
            int ba = a%2, bb = b%2, bc = c%2;
            if (bc == 1) {
                if (ba == 0 && bb == 0) {
                    res++;
                }
            } else { // bc == 0
                if (ba != 0) {
                    res++;
                }
                if (bb != 0) {
                    res++;
                }
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return res;
    }
}
