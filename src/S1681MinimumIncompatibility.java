import java.util.*;

public class S1681MinimumIncompatibility {
    int ans = Integer.MAX_VALUE;
    void helper(int[] nums, int s, LinkedList<LinkedList<Integer>> buckets, int k, int size, int total) {
        if(total >= ans) return; //early termination
        if (s == nums.length) {
            ans = total; // With early termination, Math.min() is no longer needed.
        } else {
            // distribute current number to an existing bucket
            for (int i=0; i<buckets.size(); i++) {
                LinkedList<Integer> bucket = buckets.get(i);
                if (bucket.size() < size && bucket.peekLast() < nums[s]) {
                    int distance = nums[s] - bucket.peekLast();
                    bucket.addLast(nums[s]);
                    helper(nums, s+1, buckets, k, size, total+distance);
                    bucket.removeLast();
                }
            }
            // distribute current number to an empty bucket
            if (buckets.size() < k) {
                LinkedList<Integer> bucket = new LinkedList<>();
                bucket.add(nums[s]);
                buckets.addLast(bucket);
                helper(nums, s+1, buckets, k, size, total);
                buckets.removeLast();
            }
        }
    }

    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        helper(nums, 0, new LinkedList<>(), k, nums.length/k, 0);
        return ans == Integer.MAX_VALUE?-1: ans;
    }
}
