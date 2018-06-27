import java.util.LinkedList;

public class S0063UniquePathsII {
    // TODO: dfs
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        if (obstacleGrid[N-1][M-1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] paths = new int[N][M];
        boolean[][] inQueue = new boolean[N][M];
        LinkedList<Integer> nodes = new LinkedList<>();

        paths[N-1][M-1] = 1;
        inQueue[N-1][M-1] = true;
        nodes.add(N*M-1);

        while (!nodes.isEmpty()) {
            int n = nodes.removeFirst();
            int r = n / M;
            int c = n % M;
            inQueue[r][c] = false;

            // left
            if (c > 0 && obstacleGrid[r][c-1] == 0) {
                paths[r][c-1] += paths[r][c];
                if (!inQueue[r][c-1]) {
                    nodes.add(r*M+c-1);
                    inQueue[r][c-1] = true;
                }
            }
            // up
            if (r > 0 && obstacleGrid[r-1][c] == 0) {
                paths[r-1][c] += paths[r][c];
                if (!inQueue[r-1][c]) {
                    nodes.add((r-1)*M + c);
                    inQueue[r-1][c] = true;
                }
            }
        }

        return paths[0][0];
    }
}
