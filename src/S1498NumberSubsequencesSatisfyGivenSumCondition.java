import java.util.Arrays;

public class S1498NumberSubsequencesSatisfyGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        int MOD = (int)(Math.pow(10, 9)+7);
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1 ; i < nums.length ; ++i) {
            pows[i] = pows[i - 1] * 2 % MOD;
        }

        Arrays.sort(nums);
        int l = 0;
        int r = Arrays.binarySearch(nums, target-nums[l]+1);
        if (r < 0) {
            r = -(r+1);
        }
        if (r >= nums.length) {
            r = r-1;
        }

        long res = 0;
        while (l <= r) {
            while (r >= 0 && nums[l]+nums[r] > target) {
                r--;
            }
            if (l > r) {
                break;
            }
            res = (res + pows[r-l])%MOD;
            l++;
        }
        return (int)res;
    }
}
