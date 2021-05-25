import java.util.*;

public class S1755ClosestSubsequenceSum {
    public int minAbsDifference(int[] nums, int goal) {
        if (nums.length == 1) {
            return Math.min(Math.abs(goal), Math.abs(nums[0]-goal));
        }
//        [0, nums.length/2-1], [nums.length/2, nums.length)
        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < nums.length/2; i++) {
            HashSet<Integer> next = new HashSet<>(sum);
            next.add(nums[i]);
            for (int s : sum) {
                next.add(s+nums[i]);
            }
            sum = next;
        }
        sum.add(0);
        List<Integer> first = new ArrayList<>(sum);
        Collections.sort(first);
        sum = new HashSet<>();
        for (int i = nums.length/2; i < nums.length; i++) {
            HashSet<Integer> next = new HashSet<>(sum);
            next.add(nums[i]);
            for (int s : sum) {
                next.add(s+nums[i]);
            }
            sum = next;
        }
        sum.add(0);
        int res = Math.abs(goal);
        for (int s : sum) {
            int f = goal-s;
            int p = Collections.binarySearch(first, f);
            if (p >= 0) {
                return 0;
            }
            p = -(p+1);
            if (p > 0) {
                res = Math.min(res, Math.abs(f-first.get(p-1)));
            }
            if (p < first.size()) {
                res = Math.min(res, Math.abs(f-first.get(p)));
            }
        }
        return res;
    }
}
