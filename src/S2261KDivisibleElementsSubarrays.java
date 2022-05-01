import java.util.HashMap;
import java.util.HashSet;

public class S2261KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = (nums[i]%p == 0 ? 1 : 0);
        }
        int lo = 0;
        HashSet<String> res = new HashSet<>();
        // [lo, hi]
        while (lo < nums.length) {
            int hi = lo, cnt = 0;
            StringBuilder sb = new StringBuilder();
            while (hi < nums.length && cnt <= k) {
                sb.append(nums[hi]).append(',');
                cnt += data[hi];
                if (cnt <= k) {
                    res.add(sb.toString());
                }
                hi++;
            }
            lo++;
        }
        return res.size();
    }
}
