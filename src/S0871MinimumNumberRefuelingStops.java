import java.util.Comparator;
import java.util.PriorityQueue;

public class S0871MinimumNumberRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        int fuels = 0;
        int reach = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        while (reach < target) {
            fuels++;
            while (i < stations.length && stations[i][0] <= reach) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) {
                return -1;
            }

            int s = pq.poll();
            reach += s;
        }
        return fuels;
    }
}
