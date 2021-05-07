import java.util.HashSet;

public class S1695MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int l = 0, r = 0;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (l < nums.length) {
            while (r < nums.length) {
                if (set.contains(nums[r])) {
                    break;
                }
                set.add(nums[r]);
                sum += nums[r];
                r++;
            }
            res = Math.max(res, sum);
            set.remove(nums[l]);
            sum -= nums[l];
            l++;
        }
        return res;
    }
}
