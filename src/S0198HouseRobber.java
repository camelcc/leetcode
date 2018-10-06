public class S0198HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxRob = nums[0];
        int maxNonRob = 0;
        for (int i = 1; i < nums.length; i++) {
            int rob = maxNonRob + nums[i];
            maxNonRob = Math.max(maxRob, maxNonRob);
            maxRob = rob;
        }
        return Math.max(maxNonRob, maxRob);
    }
}
