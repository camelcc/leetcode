public class S0080RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int len = 1;
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last] || last == 0 || nums[last] != nums[last-1]) {
                last++;
                nums[last] = nums[i];
                len++;
            }
        }
        return len;
    }
}
