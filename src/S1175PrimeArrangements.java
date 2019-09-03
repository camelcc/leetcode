import java.util.Arrays;

public class S1175PrimeArrangements {
    public int numPrimeArrangements(int n) {
        if (n == 1) {
            return 1;
        }
        int MOD = (int)Math.pow(10, 9) + 7;
        long res = 1;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = false;
        for (int i = 2; i <= n/2; i++) {
            int j = 2*i;
            while (j <= n) {
                prime[j-1] = false;
                j+= i;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (prime[i]) {
                cnt++;
            }
        }
        int pc = cnt, npc = n-cnt;
        long t = 1;
        while (pc > 0) {
            t *= pc;
            t = t%MOD;
            pc--;
        }
        res *= t;
        res = res%MOD;
        t = 1;
        while (npc > 0) {
            t *= npc;
            t = t%MOD;
            npc--;
        }
        res *= t;
        res = res%MOD;
        return (int)(res);
    }
}
