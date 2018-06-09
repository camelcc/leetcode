public class S0371SumTwoIntegers {
    public int getSum(int a, int b) {
        int res = 0;
        int sup = 0;

        int ba = a, bb = b, bits = 0;
        while (bits < 32 && (ba != 0 || bb != 0 || sup != 0)) {
            int s = ba&0x1;
            if ((bb&0x1) == 1) {
                s = (s == 0 ? 1 : 2);
            }
            if (sup == 0) {
                if (s == 2) {
                    sup = 1;
                } else {
                    res = res | (s << bits);
                }
            } else {
                if (s == 0) {
                    res = res | (sup << bits);
                    sup = 0;
                } else if (s == 1) {
                    // nothing, sup = 1, increase
                } else if (s == 2) {
                    res = res | (sup << bits);
                }
            }
            ba = ba >> 1;
            bb = bb >> 1;

            bits++;
        }

        return res;
    }
}
