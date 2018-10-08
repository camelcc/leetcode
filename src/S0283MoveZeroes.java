public class S0283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int moved = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (moved != i) {
                    nums[moved] = nums[i];
                }
                moved++;
            }
        }
        for (int i = moved; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
