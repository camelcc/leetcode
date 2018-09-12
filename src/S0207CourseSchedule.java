import java.util.ArrayList;
import java.util.List;

public class S0207CourseSchedule {
    private boolean[] visited = null;
    private boolean[] onStack = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }

            if (dfs(i, prerequisites)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, int[][] pre) {
        onStack[n] = true;
        visited[n] = true;

        for (int adj : adjs(pre, n)) {
            if (onStack[adj]) {
                return false;
            }

            if (!visited[adj]) {
                if (!dfs(adj, pre)) {
                    return false;
                }
            }
        }

        onStack[n] = false;
        return true;
    }

    private int[] adjs(int[][] pre, int n) {
        List<Integer> adjs = new ArrayList<>();

        for (int i = 0; i < pre.length; i++) {
            if (pre[i][1] == n) {
                adjs.add(pre[i][0]);
            }
        }

        int[] res = new int[adjs.size()];
        for (int i = 0; i < adjs.size(); i++) {
            res[i] = adjs.get(i);
        }
        return res;
    }
}
