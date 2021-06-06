import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class S1856MaximumSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        long[] sum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(o -> nums[o]));
        TreeSet<Integer> boundary = new TreeSet<>();
        boundary.add(-1);
        boundary.add(nums.length);
        long res = 0;
        for (int i = 0; i < index.length; i++) {
            int p = index[i], v = nums[p];
            int l = boundary.lower(p), r = boundary.higher(p);
            res = Math.max(res, v*(sum[r]-sum[l+1]));
            boundary.add(p);
        }
        int MOD = 1_000_000_007;
        return (int)(res%MOD);
    }
}
