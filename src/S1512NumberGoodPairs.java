import java.util.HashMap;

public class S1512NumberGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
        }
        int res = 0;
        for (int k : cnt.keySet()) {
            int c = cnt.get(k);
            res += c * (c-1) / 2;
        }
        return res;
    }
}
