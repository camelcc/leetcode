import java.util.Stack;

public class S0473MatchsticksSquare {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        if (s % 4 != 0) {
            return false;
        }
        int[] sums = new int[4];
        return dfs(nums, sums, 0, s/4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i]+nums[index] > target) {
                continue;
            }

            sums[i] += nums[index];
            if (dfs(nums, sums, index+1, target)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }
}
