import java.util.HashMap;
import java.util.HashSet;

public class S0560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Long, HashSet<Integer>> sum = new HashMap<>();
        HashSet<Integer> z = new HashSet<>();
        z.add(-1);
        sum.put(0L, z);

        long s = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            s += nums[i];

            long t = s - k;
            if (sum.containsKey(t)) {
                res += sum.get(t).size();
            }

            if (!sum.containsKey(s)) {
                sum.put(s, new HashSet<>());
            }
            sum.get(s).add(i);
        }

        return res;
    }
}
