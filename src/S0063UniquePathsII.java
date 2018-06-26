import java.util.Stack;

public class S0063UniquePathsII {
    // TODO: dfs
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        Stack<Integer> nodes = new Stack<>();
        nodes.push(0);

        while (!nodes.isEmpty()) {
            int p = nodes.pop();
            if (obstacleGrid[p/N][p%N] == 1) {
                visited[p/N][p%N] = true;
                continue;
            }

            // right
            if (p%N < M-1 && !visited[p/N][p%N + 1]) {
            }
        }

        return count;
    }
}
