import java.util.Comparator;
import java.util.PriorityQueue;

public class S2208MinimumOperationsHalveArraySum {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int n : nums) {
            sum += n;
            pq.offer((double)n);
        }
        double target = sum/2;
        int res = 0;
        while (sum > target) {
            double n = pq.poll();
            sum -= n/2;
            pq.offer(n/2);
            res++;
        }
        return res;
    }
}
