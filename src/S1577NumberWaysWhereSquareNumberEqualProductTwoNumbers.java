import java.util.Arrays;
import java.util.TreeMap;

public class S1577NumberWaysWhereSquareNumberEqualProductTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        TreeMap<Integer, Integer> cnt1 = new TreeMap<>();
        TreeMap<Integer, Integer> cnt2 = new TreeMap<>();
        for (int v : nums1) {
            cnt1.put(v, cnt1.getOrDefault(v, 0)+1);
        }
        for (int v : nums2) {
            cnt2.put(v, cnt2.getOrDefault(v, 0)+1);
        }
        int res = 0;
        for (int v : cnt1.keySet()) {
            int t = 0;
            Integer k = cnt2.ceilingKey(v);
            while (k != null && k <= v*v) {
                if (((long)v*v)%k == 0 && cnt2.containsKey((int)(((long)v)*v/k))) {
                    if (v == k) {
                        t += cnt2.get(k) * (cnt2.get(k)-1) / 2;
                    } else {
                        t += cnt2.get(k) * cnt2.get(v*v/k);
                    }
                }
                k = cnt2.higherKey(k);
            }
            res += t * cnt1.get(v);
        }
        for (int v : cnt2.keySet()) {
            int t = 0;
            Integer k = cnt1.ceilingKey(v);
            while (k != null && k <= v*v) {
                if (((long)v*v)%k == 0 && cnt1.containsKey((int)(((long)v)*v/k))) {
                    if (v == k) {
                        t += cnt1.get(k) * (cnt1.get(k)-1) / 2;
                    } else {
                        t += cnt1.get(k) * cnt1.get(v*v/k);
                    }
                }
                k = cnt1.higherKey(k);
            }
            res += t * cnt2.get(v);
        }
        return res;
    }
}
