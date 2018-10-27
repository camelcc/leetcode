public class S0055JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        int c = 0;
        while (c <= max) {
            max = Math.max(max, c+nums[c]);
            if (max >= nums.length-1) {
                return true;
            }

            c++;
        }
        return false;
    }
}
