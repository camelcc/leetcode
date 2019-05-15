import java.util.Comparator;
import java.util.PriorityQueue;

public class S0480SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        int r = 0;

        PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                // remove nums[i-k]
                assert !small.isEmpty();
                if (nums[i-k] > small.peek()) {
                    big.remove(nums[i-k]);
                    big.add(small.poll());
                } else {
                    small.remove(nums[i-k]);
                }
            }
            // add nums[i] to small if possible
            // small <= big
            if (small.isEmpty() || small.peek() >= nums[i]) {
                small.add(nums[i]);
                if (small.size() > big.size()+1) {
                    big.add(small.poll());
                }
            } else {
                big.add(nums[i]);
                if (small.size() < big.size()) {
                    small.add(big.poll());
                }
            }

            if (i >= k-1) {
                if (k % 2 == 1) {
                    res[r++] = small.peek();
                } else {
                    res[r++] = ((long)small.peek()+(long)big.peek())*0.5;
                }
            }
        }
        return res;
    }
}
