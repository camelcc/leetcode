import java.util.Comparator;
import java.util.PriorityQueue;

public class S0973KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(
                (int[] o) -> o[0]*o[0]+o[1]*o[1]).reversed());
        for (int[] point : points) {
            if (pq.size() < K) {
                pq.offer(point);
                continue;
            }
            assert pq.size() == K;
            int dis = point[0] * point[0] + point[1] * point[1];
            int[] top = pq.peek();
            if (dis < top[0]*top[0]+top[1]*top[1]) {
                pq.poll();
                pq.offer(point);
            }
        }
        int[][] res = new int[K][2];
        int i = 0;
        for (int[] t : pq) {
            res[i++] = t;
        }
        return res;
    }
}
