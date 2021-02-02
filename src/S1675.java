import java.util.Comparator;
import java.util.PriorityQueue;

public class S1675 {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n%2 == 0) {
                while (n%2 == 0) {
                    n = n/2;
                }
            }
            // n is odd
            max = Math.max(max, n);
            pq.offer(new int[]{i, n});
        }
        int res = Integer.MAX_VALUE;
        while (pq.size() == nums.length) {
            int[] t = pq.poll();
            res = Math.min(res, max-t[1]);
            if (t[1]%2 == 1 || t[1] < nums[t[0]]) {
                max = Math.max(max, t[1]*2);
                pq.offer(new int[]{t[0], t[1]*2});
            }
        }

        return res;
    }
}
