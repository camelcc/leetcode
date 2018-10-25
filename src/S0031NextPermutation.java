import java.util.Arrays;

public class S0031NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i>= 0; i--) {
            int n = Integer.MAX_VALUE;
            int ni = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i] && n > nums[j]) {
                    n = nums[j];
                    ni = j;
                }
            }
            if (ni > i) {
                int t = nums[i];
                nums[i] = n;
                nums[ni] = t;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }

        Arrays.sort(nums);
    }
}
