import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/discuss/1417576/C%2B%2BPython-Dijkstra-Clean-and-Concise
public class S1976NumberWaysArriveDestination {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        int[][] r = new int[n][n];
        for (int[] road : roads) {
            r[road[0]][road[1]] = road[2];
            r[road[1]][road[0]] = road[2];
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        long[] res = new long[n];
        res[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] t = pq.poll();
            int p = (int)t[1];
            if (t[0] > dis[p]) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (r[p][i] == 0) {
                    continue;
                }
                if (r[p][i]+t[0] < dis[i]) {
                    dis[i] = r[p][i]+t[0];
                    res[i] = res[p];
                    pq.offer(new long[]{dis[i], i});
                } else if (r[p][i]+t[0] == dis[i]) {
                    res[i] = (res[i]+res[p])%MOD;
                }
            }
        }
        return (int)res[n-1];
    }
}
