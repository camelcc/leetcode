import java.util.HashMap;

public class S1680ConcatenationConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        int[] pow = new int[32];
        pow[0] = 2;
        for (int i = 1; i < 32; i++) {
            long t = (long)pow[i-1] * pow[i-1] % MOD;
            pow[i] = (int)t;
        }

        int[] bits = new int[n+1];
        int bl = 1;
        while ((0x1<<(bl-1)) <= n) {
            for (int i = (0x1<<(bl-1)); i < (0x1<<bl) && i <= n; i++) {
                bits[i] = bl;
            }
            bl++;
        }

        int[] sum = new int[n+1];
        int s = 0;
        for (int i = n; i > 0; i--) {
            sum[i] = s;
            s += bits[i];
        }

        long res = 0;
        for (int i = 1; i <= n; i++) {
            long t = (long)i * pow(sum[i], pow);
            res = (res + t)%MOD;
        }
        return (int)res;
    }

    private int pow(int p, int[] dp) {
        if (p == 0) {
            return 1;
        }
        int bits = 0;
        while ((0x1<<bits) < p) {
            bits++;
        }
        // 2^bits >= p
        if ((0x1<<bits) == p) {
            return dp[bits];
        }

        int MOD = 1_000_000_007;
        int v = (0x1<<(bits-1));
        long res = (long)dp[bits-1]*pow(p-v, dp)%MOD;
        return (int)res;
    }
}
