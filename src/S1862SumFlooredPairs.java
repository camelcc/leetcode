import java.util.*;

// https://leetcode.com/problems/sum-of-floored-pairs/discuss/1236935/Java%3A-Sorting-with-Divide-and-Conquer
public class S1862SumFlooredPairs {
    final int mod = 1_000_000_007;

    // Returns sum of nums[i]/div for from<=i<=to.
    private int findSum(int[] nums, int from, int to, int div) {
        if (from > to) return 0;
        if (from == to) return nums[from] / div;
        if (nums[to] / div == nums[from] / div) {
            return (int)(((to - from + 1) * (long)(nums[to] / div)) % mod);
        }
        int mid = from + (to - from)/2;
        return (findSum(nums, from, mid, div) + findSum(nums, mid + 1, to, div)) % mod;
    }

    public int sumOfFlooredPairs(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        // Sorting makes the problem simple.
        Arrays.sort(nums);

        int total = 0;
        // Duplicates should be handled separately. We cannot ignore the previous numbers that are same.
        int prevNum = -1;
        int prevTotal = -1;
        for (int i=0 ; i<len ; ++i) {
            if (nums[i] == prevNum) {
                total += prevTotal;
            } else {
                prevTotal = findSum(nums, i, len-1, nums[i]);
                prevNum = nums[i];
                total += prevTotal;
            }
            total %= mod;
        }
        return total;
    }
}
