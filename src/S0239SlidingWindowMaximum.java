import java.util.LinkedList;
import java.util.Queue;

public class S0239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] res = new int[nums.length-k+1];
        int r = 0;
        Queue<Integer> max = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (i >= k-1) {
                res[r++] = Math.max(max.poll(), v);
            }
            Queue<Integer> next = new LinkedList<>();
            while (!max.isEmpty()) {
                next.add(Math.max(max.poll(), v));
            }
            next.add(v);
            max = next;
        }
        return res;
    }
}
