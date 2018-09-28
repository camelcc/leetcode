public class S0213HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // rob 0
        int[] maxRob = new int[nums.length];
        int[] maxNotRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxNotRob[0] = 0;
        int max0 = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            maxRob[i] = maxNotRob[i-1] + nums[i];
            maxNotRob[i] = Math.max(maxRob[i-1], maxNotRob[i-1]);
            max0 = Math.max(maxRob[i], maxNotRob[i]);
        }

        // not rob 0
        int max1 = 0;
        maxRob = new int[nums.length];
        maxNotRob = new int[nums.length];
        maxRob[1] = nums[1];
        maxNotRob[1] = 0;

        for (int i = 1; i < nums.length; i++) {
            maxRob[i] = maxNotRob[i-1] + nums[i];
            maxNotRob[i] = Math.max(maxRob[i-1], maxNotRob[i-1]);
            max1 = Math.max(maxRob[i], maxNotRob[i]);
        }
        return Math.max(max0, max1);
    }
}
