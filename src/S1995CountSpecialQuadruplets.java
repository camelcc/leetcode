import java.util.HashMap;

public class S1995CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        HashMap<Integer, Integer>[] cnt = new HashMap[3];
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = new HashMap<>();
        }
        int res = 0;
        for (int n : nums) {
            if (cnt[2].containsKey(n)) {
                res += cnt[2].get(n);
            }
            for (int k : cnt[1].keySet()) {
                cnt[2].put(k+n,
                        cnt[2].getOrDefault(k+n, 0) +
                        cnt[1].get(k));
            }
            for (int k : cnt[0].keySet()) {
                cnt[1].put(k+n,
                        cnt[1].getOrDefault(k+n, 0) +
                        cnt[0].get(k));
            }
            cnt[0].put(n, cnt[0].getOrDefault(n, 0)+1);
        }
        return res;
    }
}
