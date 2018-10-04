public class S0027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int current = 0;
        while (current < len) {
            if (nums[current] == val) {
                nums[current] = nums[len-1];
                len--;
            } else {
                current++;
            }
        }

        return len;
    }
}
