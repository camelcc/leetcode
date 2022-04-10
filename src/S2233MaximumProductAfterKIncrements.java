import java.util.PriorityQueue;

public class S2233MaximumProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        int MOD = 1_000_000_007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
        }
        while (k > 0) {
            pq.offer(pq.poll()+1);
            k--;
        }

        long res = 1;
        while (!pq.isEmpty()) {
            res = (res * pq.poll())%MOD;
            if (res == 0) {
                return 0;
            }
        }
        return (int)res;
    }
}
