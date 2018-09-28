public class S0198HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] maxRob = new int[nums.length];
        int[] maxNotRob = new int[nums.length];
        int max = nums[0];
        maxRob[0] = nums[0];
        maxNotRob[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            maxRob[i] = maxNotRob[i-1] + nums[i];
            maxNotRob[i] = Math.max(maxRob[i-1], maxNotRob[i-1]);
            max = Math.max(maxRob[i], maxNotRob[i]);
        }
        return max;
    }
}
