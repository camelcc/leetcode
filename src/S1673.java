import java.util.PriorityQueue;

public class S1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> {
            if (nums[o1] != nums[o2]) {
                return nums[o1]-nums[o2];
            }
            return o1-o2;
        });

        int[] res = new int[k];
        int ri = 0, ni = 0, mi = 0;
        while (k > 0) {
            while (ni < nums.length - (k-1)) {
                pq.offer(ni);
                ni++;
            }
            // pick the min
            int t = pq.poll();
            while (t < mi && !pq.isEmpty()) {
                t = pq.poll();
            }
            res[ri++] = nums[t];
            mi = t+1;
            k--;
        }
        return res;
    }
}
