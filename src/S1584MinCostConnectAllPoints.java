import java.util.*;

public class S1584MinCostConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int res = 0;

        boolean[] connected = new boolean[points.length];
        HashMap<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist.getOrDefault(o, Integer.MAX_VALUE)));

        dist.put(0, 0);
        pq.offer(0);
        while (!pq.isEmpty()) {
            int v = pq.poll();
            res += dist.get(v);
            visit(points, connected, v, dist, pq);
        }
        return res;
    }

    private void visit(int[][] points, boolean[] visited, int v, HashMap<Integer, Integer> dist, PriorityQueue<Integer> pq) {
        visited[v] = true;
        for (int i = 0; i < points.length; i++) {
            if (visited[i]) {
                continue;
            }
            int c = cost(points, v, i);
            if (c < dist.getOrDefault(i, Integer.MAX_VALUE)) {
                dist.put(i, c);
                if (pq.contains(i)) {
                    pq.remove(i);
                }
                pq.offer(i);
            }
        }
    }

    private int cost(int[][] points, int i, int j) {
        int res = 0;
        res += Math.abs(points[i][0]-points[j][0]);
        res += Math.abs(points[i][1]-points[j][1]);
        return res;
    }
}
