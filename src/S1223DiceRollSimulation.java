import java.util.Arrays;

public class S1223DiceRollSimulation {
    public int dieSimulator(int n, int[] rollMax) {
        if (n == 1) {
            return 6;
        }

        int MOD = (int)Math.pow(10, 9)+7;
        long[][] cnt = new long[7][16];
        cnt[1][1] = 1;
        cnt[2][1] = 1;
        cnt[3][1] = 1;
        cnt[4][1] = 1;
        cnt[5][1] = 1;
        cnt[6][1] = 1;

        int step = 1;
        while (step < n) {
            long[][] next = new long[7][16];
            for (int roll = 1; roll <= 6; roll++) {
                long c = 0;
                for (int r = 1; r <= 6; r++) {
                    if (roll == r) {
                        continue;
                    }
                    for (int t = 0; t < 16; t++) {
                        c += cnt[r][t];
                    }
                }
                c = c%MOD;
                next[roll][1] = c;

                for (int times = 2; times <= rollMax[roll-1]; times++) {
                    next[roll][times] = cnt[roll][times-1];
                }
            }
            cnt = next;
            step++;
        }
        long res = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 16; c++) {
                res += cnt[r][c];
                res = res % MOD;
            }
        }
        return (int)res;
    }
}
