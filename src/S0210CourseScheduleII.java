import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S0210CourseScheduleII {
    Stack<Integer> postReverse = new Stack<>();
    boolean[] visited = new boolean[0];
    boolean[] onStack = new boolean[0];

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[0];

        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }

            if (!dfs(i, prerequisites)) {
                return order;
            }
        }

        order = new int[postReverse.size()];
        int o = 0;
        while (!postReverse.isEmpty()) {
            order[o++] = postReverse.pop();
        }
        return order;
    }

    private boolean dfs(int n, int[][] pre) {
        onStack[n] = true;
        visited[n] = true;

        for (int adj : adjs(n, pre)) {
            if (onStack[adj]) {
                return false;
            }

            if (visited[adj]) {
                continue;
            }

            if (!dfs(adj, pre)) {
                return false;
            }
        }

        postReverse.push(n);
        onStack[n] = false;
        return true;
    }

    private int[] adjs(int n, int[][] pre) {
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
