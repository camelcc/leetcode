public class S2293MinMaxGame {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] res = new int[nums.length/2];
        for (int i = 0; i < res.length; i++) {
            if (i%2 == 0) {
                res[i] = Math.min(nums[2*i], nums[2*i+1]);
            } else {
                res[i] = Math.max(nums[2*i], nums[2*i+1]);
            }
        }
        return minMaxGame(res);
    }
}
