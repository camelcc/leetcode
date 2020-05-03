import java.util.Comparator;
import java.util.PriorityQueue;

public class S1438LongestContinuousSubarrayWithAbsoluteDiffLessEqualLimit {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0, end = 0, len = 1;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(Comparator.comparingInt(o->nums[o]));
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.comparingInt((Integer o)->nums[o]).reversed());

        while (end < nums.length) {
            if (start + len >= nums.length) {
                break;
            }
            while (end < start+len) {
                minPQ.offer(end);
                maxPQ.offer(end);
                end++;
            }

            while (end < nums.length) {
                minPQ.offer(end);
                maxPQ.offer(end);
                if (nums[maxPQ.peek()] - nums[minPQ.peek()] <= limit) {
                    len = Math.max(len, end-start+1);
                    end++;
                } else {
                    end++;
                    break;
                }
            }


            minPQ.remove(start);
            maxPQ.remove(start);
            start++;
        }

        return len;
    }
}
