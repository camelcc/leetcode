import java.util.Arrays;

public class S1509MinimumDifferenceBetweenLargestSmallestValueThreeMoves {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return Math.min(Math.min(nums[len-4]-nums[0], Math.min(nums[len-3]-nums[1], nums[len-2]-nums[2])), nums[len-1]-nums[3]);
    }
}
