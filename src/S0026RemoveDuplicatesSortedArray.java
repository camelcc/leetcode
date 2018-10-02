public class S0026RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        int len = 1;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[current]) {
                continue;
            } else {
                if (current + 1 != i) {
                    nums[current + 1] = nums[i];
                }

                current++;
                len++;
            }
        }
        return len;
    }
}
