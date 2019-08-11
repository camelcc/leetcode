import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class S1157OnlineMajorityElementInSubarray {
    public static class MajorityChecker {
        private HashMap<Integer, TreeMap<Integer, Integer>> occur;
        private int[] data;
        private int shard;

        public MajorityChecker(int[] arr) {
            this.data = arr;
            shard = (int)Math.sqrt(arr.length);
            occur = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                occur.putIfAbsent(arr[i], new TreeMap<>());
                TreeMap<Integer, Integer> freq = occur.get(arr[i]);
                Map.Entry<Integer, Integer> t = freq.floorEntry(i);
                freq.put(i, t == null ? 1 : t.getValue()+1);
            }
        }

        public int query(int left, int right, int threshold) {
            if (right-left+1 > shard) {
                for (int num : occur.keySet()) {
                    TreeMap<Integer, Integer> cnt = occur.get(num);
                    if (cnt.size() < threshold) {
                        continue;
                    }
                    Map.Entry<Integer, Integer> r = cnt.floorEntry(right);
                    if (r == null) {
                        continue;
                    }
                    int rc = r.getValue();
                    Map.Entry<Integer, Integer> l = cnt.floorEntry(left-1);
                    int lc = l == null ? 0 : l.getValue();
                    if (rc-lc >= threshold) {
                        return num;
                    }
                }
             } else {
                HashMap<Integer, Integer> cnt = new HashMap<>();
                for (int i = left; i <= right; i++) {
                    cnt.put(data[i], cnt.getOrDefault(data[i], 0)+1);
                    if (cnt.get(data[i]) >= threshold) {
                        return data[i];
                    }
                }
            }
            return -1;
        }
    }
}
