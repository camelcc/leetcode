import java.util.PriorityQueue;

public class S1499MaxValueEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o2[0]-o1[0]);
        for (int[] point: points) {
            int x = point[0], y = point[1], s = x+y;
            while (!pq.isEmpty() && (x - pq.peek()[1]) > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res = Math.max(res, pq.peek()[0] + s);
            }
            pq.offer(new int[]{y-x, x});
        }

        return res;
    }
}
