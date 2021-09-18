import java.util.HashMap;

public class S2006CountNumberPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
        }
        for (int n : nums) {
            res += cnt.getOrDefault(n-k, 0);
            res += cnt.getOrDefault(n+k, 0);
        }
        return res/2;
    }
}
