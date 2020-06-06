import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S1462CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashSet<Integer>[] pre = new HashSet[n];
        for (int i = 0; i < n; i++) {
            pre[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            pre[p[1]].add(p[0]);
        }

        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> bfs = new LinkedList<>(pre[i]);
            while (!bfs.isEmpty()) {
                int c = bfs.poll();
                if (!graph[i][c]) {
                    bfs.addAll(pre[c]);
                    graph[i][c] = true;
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(graph[query[1]][query[0]]);
        }
        return res;
    }
}
