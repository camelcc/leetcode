public class S0191Number1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((n & 0x1) == 0 ? 0 : 1);
            n = n >> 1;
        }
        return count;
    }
}
