import java.util.Arrays;

public class S1838FrequencyMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }

        int l = 0, r = 1, res = 1;
        while (r < nums.length) {
            s = (r-l+1)*nums[r]-(sum[r]-(l>0?sum[l-1]:0));
            if (s <= k) {
                res = Math.max(res, r-l+1);
                r++;
                continue;
            }
            // r < nums.len && s > k
            l++;
        }
        return res;
    }
}
