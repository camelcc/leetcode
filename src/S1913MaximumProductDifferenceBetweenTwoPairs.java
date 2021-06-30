import java.util.Arrays;

public class S1913MaximumProductDifferenceBetweenTwoPairs {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1]*nums[nums.length-2];
        int min = nums[0]*nums[1];
        return max-min;
    }
}
