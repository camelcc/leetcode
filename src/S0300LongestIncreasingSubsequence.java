import java.util.Arrays;

public class S0300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int len = 0;
        int[] tails = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            int index = Arrays.binarySearch(tails, 0, len, v);
            if (index < 0) {
                index = -index-1;
            }
            tails[index] = v;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
