public class S2220MinimumBitFlipsConvertNumber {
    public int minBitFlips(int start, int goal) {
        int diff = start ^ goal, res = 0;
        while (diff != 0) {
            res += diff&0x1;
            diff = diff >> 1;
        }
        return res;
    }
}
