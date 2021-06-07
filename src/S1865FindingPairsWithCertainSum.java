import java.util.HashMap;

public class S1865FindingPairsWithCertainSum {
    public static class FindSumPairs {
        HashMap<Integer, Integer> cnt1 = new HashMap<>();
        HashMap<Integer, Integer> cnt2  = new HashMap<>();
        int[] data;

        public FindSumPairs(int[] nums1, int[] nums2) {
            for (int n : nums1) {
                cnt1.put(n, cnt1.getOrDefault(n, 0)+1);
            }
            data =nums2;
            for (int n : nums2) {
                cnt2.put(n, cnt2.getOrDefault(n, 0)+1);
            }
        }

        public void add(int index, int val) {
            int v = data[index];
            if (cnt2.get(v) == 1) {
                cnt2.remove(v);
            } else {
                cnt2.put(v, cnt2.get(v)-1);
            }
            v += val;
            data[index] = v;
            cnt2.put(v, cnt2.getOrDefault(v, 0)+1);
        }

        public int count(int tot) {
            int res = 0;
            for (int k : cnt1.keySet()) {
                res += cnt1.get(k)*cnt2.getOrDefault(tot-k, 0);
            }
            return res;
        }
    }
}
