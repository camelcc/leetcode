public class S0238ProductArrayExceptSelf {
    //TODO: brilliant idea
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int rightMulti = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] = res[i] * rightMulti;
            rightMulti *= nums[i];
        }

        return res;
    }
}
