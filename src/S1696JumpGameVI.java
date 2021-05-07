import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

public class S1696JumpGameVI {
    public int maxResult(int[] nums, int k) {
        Integer[] dp = new Integer[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((ToIntFunction<int[]>) o -> o[1]).reversed());
        pq.offer(new int[]{nums.length-1, nums[nums.length-1]});
        int i = nums.length-2;
        while (i >= 0) {
            int[] t = pq.peek();
            if (t[0] > i+k) {
                pq.poll();
                continue;
            }
            dp[i] = t[1]+nums[i];
            pq.offer(new int[]{i, dp[i]});
            i--;
        }
        return dp[0];
    }
}
