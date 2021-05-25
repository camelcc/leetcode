public class S1752CheckArraySortedRotated {
    public boolean check(int[] nums) {
        int p = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (p != -1) {
                    return false;
                }
                p = i;
            }
        }
        if (p == -1) {
            return true;
        } else {
            return nums[nums.length-1] <= nums[0];
        }
    }
}
