import java.util.HashMap;
import java.util.HashSet;

public class S2176CountEqualDivisiblePairsArray {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, HashSet<Integer>> pos = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            pos.putIfAbsent(v, new HashSet());

            for (int j : pos.get(v)) {
                if ((i*j)%k == 0) {
                    res++;
                }
            }
            pos.get(v).add(i);
        }
        return res;
    }
}
