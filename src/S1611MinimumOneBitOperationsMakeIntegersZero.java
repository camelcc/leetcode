import java.util.HashMap;

public class S1611MinimumOneBitOperationsMakeIntegersZero {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);

        int bits = 0x1;
        int t = n;
        while (t != 1) {
            t = t >> 1;
            bits = bits << 1;
            dp.put(bits, bits + dp.get(bits >> 1));
        }
        int remains = n-bits;
        return toOne(remains, bits>>1, dp) + 1 + dp.get(bits>>1);
    }

    private int toZero(int n, int bit, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        if (n < bit) {
            return toZero(n, bit>>1, dp);
        }
        return toOne(n-bit, bit>>1, dp) + 1 + dp.get(bit>>1);
    }

    private int toOne(int n, int bit, HashMap<Integer, Integer> dp) {
        if (n == bit) {
            return 0;
        }
        if (n > bit) {
            return toZero(n-bit, bit>>1, dp);
        }
        int res = dp.get(bit>>1) + 1;
        res += toOne(n, bit>>1, dp);
        return res;
    }
}
