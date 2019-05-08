import java.util.Arrays;

public class S0330PatchingArray {
    public int minPatches(int[] nums, int n) {
        Arrays.sort(nums);
        int res = 0;
        long up = 0;
        int i = 0;
        while (up < n) {
            if (i < nums.length && nums[i] <= up+1) {
                up += nums[i];
                i++;
            } else {
                res++;
                up += up + 1;
            }
        }
        return res;
    }
}
