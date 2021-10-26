import java.util.HashSet;
import java.util.LinkedList;

public class S2050ParallelCoursesIII {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n+1];
        HashSet<Integer>[] post = new HashSet[n+1];
        for (int i = 0; i <= n; i++) {
            post[i] = new HashSet<>();
        }
        for (int[] relation : relations) {
            indegree[relation[1]]++;
            post[relation[0]].add(relation[1]);
        }
        int[] dist = new int[n+1];
        LinkedList<Integer> pq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
                dist[i] = time[i-1];
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int c = pq.poll();
            for (int p : post[c]) {
                int nt = dist[c] + time[p-1];
                dist[p] = Math.max(dist[p], nt);
                indegree[p]--;
                if (indegree[p] == 0) {
                    pq.offer(p);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
