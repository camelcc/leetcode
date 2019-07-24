import java.util.PriorityQueue;

public class S1109CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        for (int[] book : bookings) {
            pq.offer(new int[]{book[0], book[2]});
            pq.offer(new int[]{book[1]+1, -book[2]});
        }
        int v = 0;
        for (int i = 1; i <= n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] == i) {
                v += pq.poll()[1];
            }
            res[i-1] = v;
        }
        return res;
    }
}
