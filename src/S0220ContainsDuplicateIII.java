import java.util.HashMap;
import java.util.Map;

public class S0220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long mapped = (long)nums[i] - Integer.MIN_VALUE;
            long b = mapped / ((long)t+1);

            if (buckets.containsKey(b) ||
                    (buckets.containsKey(b-1) && (mapped - buckets.get(b-1)) <= t) ||
                    (buckets.containsKey(b+1) && (buckets.get(b+1) - mapped) <= t)) {
                return true;
            }

            if (buckets.size() >= k) {
                long lb = ((long)nums[i-k] - Integer.MIN_VALUE)/((long)t+1);
                buckets.remove(lb);
            }
            buckets.put(b, mapped);
        }
        return false;
    }
}
