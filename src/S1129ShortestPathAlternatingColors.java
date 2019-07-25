import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1129ShortestPathAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] distance = new int[2][n];
        Arrays.fill(distance[0], Integer.MAX_VALUE);
        Arrays.fill(distance[1], Integer.MAX_VALUE);

        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{0, 0, 0});
        bfs.offer(new int[]{0, 0, 1});
        while (!bfs.isEmpty()) {
            int[] node = bfs.poll();
            if (distance[node[2]][node[0]] <= node[1]) {
                continue;
            }
            distance[node[2]][node[0]] = node[1];
            if (node[2] == 0) { // red
                for (int[] blue : blue_edges) {
                    if (blue[0] != node[0]) {
                        continue;
                    }
                    bfs.offer(new int[]{blue[1], node[1]+1, 1});
                }
            } else { // blue
                for (int[] red : red_edges) {
                    if (red[0] != node[0]) {
                        continue;
                    }
                    bfs.offer(new int[]{red[1], node[1]+1, 0});
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int d = Math.min(distance[0][i], distance[1][i]);
            res[i] = (d == Integer.MAX_VALUE ? -1 : d);
        }
        return res;
    }
}
