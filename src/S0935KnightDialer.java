import java.util.Arrays;

public class S0935KnightDialer {
    public int knightDialer(int N) {
        int MOD = (int)Math.pow(10, 9)+7;
        int[][] hops = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        long[] comb = new long[10];
        Arrays.fill(comb, 1);
        for (int i = 1; i < N; i++) {
            long[] next = new long[10];
            for (int src = 0; src < 10; src++) {
                for (int dst : hops[src]) {
                    next[dst] += comb[src];
                }
            }
            comb = next;
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + comb[i])%MOD;
        }
        return (int)res;
    }
}
