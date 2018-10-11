public class S0453MinimumMovesEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i]-min;
        }
        return res;
    }
}
