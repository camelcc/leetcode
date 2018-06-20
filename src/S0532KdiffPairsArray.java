import java.util.Arrays;

public class S0532KdiffPairsArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = 1;
        while (i < nums.length-1) {
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }

            j = i+1;
            boolean hasMatch = false;
            while (j < nums.length && nums[j]-nums[i] <= k) {
                if (nums[j]-nums[i] == k) {
                    hasMatch = true;
                    break;
                } else {
                    j++;
                }
            }
            if (hasMatch) {
                count++;
            }
            i++;
        }
        return count;
    }
}
