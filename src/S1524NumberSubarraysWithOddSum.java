import java.util.Arrays;

public class S1524NumberSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int even = 0;
        int odd = 0;
        long res = 0;
        int MOD = (int)(Math.pow(10, 9)+7);
        for (int v : arr) {
            int e = 0;
            int o = 0;
            if (v%2 == 0) { // even
                e = 1 + even;
                o = odd;
            } else { // odd
                e = odd;
                o = 1 + even;
            }
            even = e;
            odd = o;
            res = (res + odd)%MOD;
        }
        return (int)res;
    }
}
