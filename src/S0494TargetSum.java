import java.util.HashMap;

public class S0494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>();
        }
        return count(nums, 0, maps, S);
    }

    private int count(int[] nums, int start, HashMap<Integer, Integer>[] maps, int target) {
        if (maps[start].containsKey(target)) {
            return maps[start].get(target);
        }
        if (start == nums.length-1) {
            int cnt = 0;
            if (target == nums[start]) {
                cnt++;
            }
            if (target == -nums[start]) {
                cnt++;
            }
            maps[start].put(target, cnt);
            return cnt;
        }

        int count = 0;
        count += count(nums, start+1, maps, target-nums[start]);
        count += count(nums, start+1, maps, target+nums[start]);
        maps[start].put(target, count);
        return count;
    }
}
