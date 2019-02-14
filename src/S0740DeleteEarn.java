import java.util.Arrays;

public class S0740DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        int prevVal = -1;
        int preSum = 0;
        int prevprevSum = 0;

        int curVal = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                curSum += nums[i];
            } else {
                int t = preSum;
                if (curVal - prevVal == 1) {
                    preSum = Math.max(prevprevSum + curSum, preSum);
                } else {
                    preSum = preSum + curSum;
                }
                prevprevSum = t;
                prevVal = curVal;
                curVal = nums[i];
                curSum = nums[i];
            }
        }

        int res = 0;
        if (curVal - prevVal == 1) {
            res = Math.max(prevprevSum+curSum, preSum);
        } else {
            res = preSum + curSum;
        }
        return res;
    }
}
