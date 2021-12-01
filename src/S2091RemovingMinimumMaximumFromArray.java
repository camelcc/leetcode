public class S2091RemovingMinimumMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        int min = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int l = Math.min(min, max), r = Math.max(min, max);
        return Math.min(l+1+nums.length-r, Math.min(r+1, nums.length-l));
    }
}
