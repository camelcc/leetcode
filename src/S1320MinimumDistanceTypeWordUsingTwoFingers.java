import java.util.Arrays;

public class S1320MinimumDistanceTypeWordUsingTwoFingers {
    public int minimumDistance(String word) {
        int[][] dp = new int[30][30];
        for (char c : word.toCharArray()) {
            int p = c-'A';

            int[][] next = next();
            for (int l = 0; l < 30; l++) {
                for (int r = 0; r < 30; r++) {
                    if (dp[l][r] == -1) {
                        continue;
                    }

                    int d = dp[l][r];
                    // left
                    int ld = dp[l][r] + distance(l, p);
                    if (next[p][r] == -1) {
                        next[p][r] = ld;
                    } else {
                        next[p][r] = Math.min(next[p][r], ld);
                    }
                    // right
                    int rd = dp[l][r] + distance(r, p);
                    if (next[l][p] == -1) {
                        next[l][p] = rd;
                    } else {
                        next[l][p] = Math.min(next[l][p], rd);
                    }
                }
            }

            dp = next;
        }

        int res = -1;
        for (int l = 0; l < 30; l++) {
            for (int r = 0; r < 30; r++) {
                if (dp[l][r] == -1) {
                    continue;
                }
                if (res == -1) {
                    res = dp[l][r];
                } else {
                    res = Math.min(res, dp[l][r]);
                }
            }
        }
        return res;
    }

    private int[][] next() {
        int[][] res = new int[30][30];
        for (int i = 0; i < 30; i++) {
            Arrays.fill(res[i], -1);
        }
        return res;
    }

    private int distance(int pa, int pb) {
        int xa = pa%6, ya = pa/6;
        int xb = pb%6, yb = pb/6;
        return Math.abs(xa-xb)+Math.abs(ya-yb);
    }
}
