public class S0287FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
