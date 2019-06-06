import java.util.Arrays;
import java.util.LinkedList;

public class S0882ReachableNodesSubdividedGraph {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] adjs = new int[N][N];
        for (int[] edge : edges) {
            adjs[edge[0]][edge[1]] = edge[2]+1;
            adjs[edge[1]][edge[0]] = edge[2]+1;
        }

        int[] steps = new int[N];
        Arrays.fill(steps, -1);
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0, M});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int n = t[0];
            int s = t[1];
            if (steps[n] >= s) {
                continue;
            }
            steps[n] = s;
            for (int i = 0; i < N; i++) {
                if (adjs[n][i] == 0 || s-adjs[n][i] < 0) {
                    continue;
                }
                bfs.add(new int[]{i, s-adjs[n][i]});
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (steps[i] >= 0) {
                res++;
            }
            for (int j = 0; j < i; j++) {
                if (adjs[i][j] == 0) {
                    continue;
                }
                if (Math.max(0, steps[i])+Math.max(steps[j], 0) >= adjs[i][j]) {
                    res += adjs[i][j]-1;
                } else {
                    res += Math.max(0, steps[i])+Math.max(0, steps[j]);
                }
            }
        }
        return res;
    }
}
