import java.util.ArrayList;
import java.util.List;

public class S0886PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] adjs = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] dis : dislikes) {
            adjs[dis[0]].add(dis[1]);
            adjs[dis[1]].add(dis[0]);
        }

        int[] color = new int[N+1]; // 0 - not visited, 1 - white, 2 - black
        for (int i = 1; i <= N; i++) {
            if (color[i] != 0) {
                continue;
            }

            color[i] = 1;
            if (!dfs(i, color, adjs)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[] color, List<Integer>[] adjs) {
        assert color[i] != 0;
        int adjColor = color[i] == 1 ? 2 : 1;
        for (int adj : adjs[i]) {
            if (color[adj] == 0) {
                color[adj] = adjColor;
                if (!dfs(adj, color, adjs)) {
                    return false;
                }
            } else {
                if (color[adj] != adjColor) {
                    return false;
                }
            }
        }

        return true;
    }
}
