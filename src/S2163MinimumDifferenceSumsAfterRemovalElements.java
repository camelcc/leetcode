import java.util.Comparator;
import java.util.PriorityQueue;

public class S2163MinimumDifferenceSumsAfterRemovalElements {
    public long minimumDifference(int[] nums) {
        int N = nums.length/3;
        long sum = 0;
        PriorityQueue<Integer> lpq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            lpq.offer(nums[i]);
        }

        long[] left = new long[N+1];
        left[0] = sum;
        // [0, i]
        for (int i = N; i < 2*N; i++) {
            if (lpq.peek() <= nums[i]) {
                left[i-N+1] = sum;
                continue;
            }
            sum -= lpq.poll();
            lpq.offer(nums[i]);
            sum += nums[i];
            left[i-N+1] = sum;
        }

        sum = 0;
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        for (int i = nums.length-1; i >= 2*N; i--) {
            sum += nums[i];
            rpq.offer(nums[i]);
        }

        long[] right = new long[N+1];
        right[N] = sum;
        for (int i = 2*N-1; i >= N; i--) {
            if (rpq.peek() >= nums[i]) {
                right[i-N] = sum;
                continue;
            }
            sum -= rpq.poll();
            rpq.offer(nums[i]);
            sum += nums[i];
            right[i-N] = sum;
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            res = Math.min(res, left[i]-right[i]);
        }
        return res;
    }
}
