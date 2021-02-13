import java.util.HashMap;

public class S1546MaximumNumberNonOverlappingSubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = 0;
            int pre = sum-target;
            if (map.containsKey(pre)) {
                int p = map.get(pre);
                t = 1 + (p >= 0 ? dp[p] : 0);
            }
            map.put(sum, i);
            if (i == 0) {
                dp[i] = t;
            } else {
                dp[i] = Math.max(dp[i-1], t);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
