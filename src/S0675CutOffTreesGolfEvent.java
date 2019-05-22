import java.util.*;

public class S0675CutOffTreesGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.isEmpty() || forest.get(0).isEmpty()) {
            return 0;
        }
        int M = forest.size(), N = forest.get(0).size();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> forest.get(o[0]).get(o[1])));
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (forest.get(r).get(c) > 1) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int res = 0;

        int[] current = new int[]{0, 0};

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int t = bfs(forest, current[0], current[1], next[0], next[1]);
            if (t == -1) {
                return -1;
            }
            res += t;
            current = next;
        }

        return res;
    }

    public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc, 0});
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tr && cur[1] == tc) return cur[2];
            for (int di = 0; di < 4; ++di) {
                int r = cur[0] + dr[di];
                int c = cur[1] + dc[di];
                if (0 <= r && r < R && 0 <= c && c < C &&
                        !seen[r][c] && forest.get(r).get(c) > 0) {
                    seen[r][c] = true;
                    queue.add(new int[]{r, c, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}
