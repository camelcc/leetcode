import java.util.Comparator;
import java.util.PriorityQueue;

public class S0407TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int M = heightMap.length, N = heightMap[0].length;
        int res = 0;
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for (int i = 0; i < M; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            if (N > 1) {
                queue.add(new int[]{i, N-1, heightMap[i][N-1]});
                visited[i][N-1] = true;
            }
        }
        for (int i = 1; i < N-1; i++) {
            queue.add(new int[]{0, i, heightMap[0][i]});
            visited[0][i] = true;
            if (M > 1) {
                queue.add(new int[]{M-1, i, heightMap[M-1][i]});
                visited[M-1][i] = true;
            }
        }

        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] low = queue.poll();
            for (int[] dir : dirs) {
                int r = low[0]+dir[0];
                int c = low[1]+dir[1];
                if (r >= 0 && r < M && c >= 0 && c < N && !visited[r][c]) {
                    visited[r][c] = true;
                    res += Math.max(heightMap[r][c], low[2])-heightMap[r][c];
                    queue.add(new int[]{r, c, Math.max(heightMap[r][c], low[2])});
                }
            }
        }
        return res;
    }
}
