import java.util.Arrays;
import java.util.Comparator;

public class S1589MaximumSumObtainedAnyPermutation {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] cnt = new int[nums.length];
        for (int[] req : requests) {
            cnt[req[0]]++;
            if (req[1]+1 < nums.length) {
                cnt[req[1]+1]--;
            }
        }
        int[] c = new int[nums.length];
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t += cnt[i];
            c[i] = t;
        }
        Arrays.sort(c);
        Arrays.sort(nums);
        long res = 0;
        int MOD = (int)(Math.pow(10, 9) + 7);
        for (int i = 0; i < nums.length; i++) {
            res = (res + (long)c[i] * nums[i])%MOD;
        }
        return (int)(res);
    }
}
