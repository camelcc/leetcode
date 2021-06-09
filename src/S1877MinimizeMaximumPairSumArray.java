import java.util.Arrays;

public class S1877MinimizeMaximumPairSumArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length/2; i++) {
            res = Math.max(res, nums[i]+nums[nums.length-1-i]);
        }
        return res;
    }
}
