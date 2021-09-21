import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/discuss/1471265/Java-Sort-%2B-sliding-window-(faster-than-94)
public class S2009MinimumNumberOperationsMakeArrayContinuous {
    public int minOperations(int[] nums) {
        Arrays.sort(nums); // Sort the array

        int n = nums.length;
        int maxNumsInWindow = 0;

        Deque<Integer> numsInWindow = new ArrayDeque<>();
        for (int num : nums) {
            // Advance the window
            while (numsInWindow.size() > 0 && num - numsInWindow.peekFirst() >= n) {
                numsInWindow.poll();
            }

            // Add the new number to the window (if it's not a duplicate)
            if(numsInWindow.size() == 0 || ! numsInWindow.peekLast().equals(num)) {
                numsInWindow.offer(num);
            }

            maxNumsInWindow = Math.max(maxNumsInWindow, numsInWindow.size());
        }

        return n - maxNumsInWindow;
    }
}
