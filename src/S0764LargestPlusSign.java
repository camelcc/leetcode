import java.util.Arrays;

public class S0764LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dis[i], N);
        }
        for (int[] mine: mines) {
            dis[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int c = 0, l = 0; c < N; c++) {
                l = (dis[i][c] == 0 ? 0 : l+1);
                dis[i][c] = Math.min(dis[i][c], l);
            }

            for (int c = N-1, r = 0; c >= 0; c--) {
                r = (dis[i][c] == 0 ? 0 : r+1);
                dis[i][c] = Math.min(dis[i][c], r);
            }

            for (int r = 0, t = 0; r < N; r++) {
                t = (dis[r][i] == 0 ? 0 : t+1);
                dis[r][i] = Math.min(dis[r][i], t);
            }

            for (int r = N-1, b = 0; r >= 0; r--) {
                b = (dis[r][i] == 0 ? 0 : b+1);
                dis[r][i] = Math.min(dis[r][i], b);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dis[i][j]);
            }
        }
        return res;
    }
}
