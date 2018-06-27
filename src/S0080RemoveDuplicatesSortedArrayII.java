public class S0080RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int len = nums.length;

        int lastIndex = 0;
        int last = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] == last) {
                continue;
            }

            if (i - lastIndex <= 2) {
                last = nums[i];
                lastIndex = i;
                continue;
            }

            for (int j = i, k = lastIndex+2; j < len; j++, k++) {
                nums[k] = nums[j];
            }
            len -= i - (lastIndex+2);
            i = lastIndex+2;
            lastIndex = i;
            last = nums[lastIndex];
        }

        if (len - lastIndex > 2) {
            len -= len - (lastIndex+2);
        }
        return len;
    }
}
