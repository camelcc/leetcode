import java.util.Arrays;

public class S0594LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;

        int preCount = 0;
        int preNum = nums[0] - 2;
        int currentCount = 0;
        int currentNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentCount++;
            } else {
                if (currentNum - preNum == 1) {
                    if (max < preCount + currentCount) {
                        max = preCount + currentCount;
                    }
                }
                preCount = currentCount;
                preNum = currentNum;
                currentCount = 1;
                currentNum = nums[i];
            }
        }
        if (currentNum - preNum == 1) {
            if (max < preCount + currentCount) {
                max = preCount + currentCount;
            }
        }
        return max;
    }
}
