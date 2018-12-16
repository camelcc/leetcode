import java.util.HashSet;

public class S0523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 && ((i > 0 && nums[i-1] == 0) || (i < nums.length-1 && nums[i+1] == 0))) {
                    return true;
                }
            }
            return false;
        }
        if (k == 1) {
            return true;
        }

        HashSet<Integer> remains = new HashSet<>();
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (s%k == 0 && i > 0) {
                return true;
            }
            if (remains.contains(s%k)) {
                return true;
            } else {
                remains.add(s%k);
            }
        }
        return false;
    }
}
