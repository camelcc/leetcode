import java.util.*;

public class S1224MaximumEqualFrequency {
    public int maxEqualFreq(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freq = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int f = cnt.getOrDefault(v, 0);
            cnt.put(v, f+1);
            if (f != 0) {
                freq.get(f).remove(v);
                if (freq.get(f).isEmpty()) {
                    freq.remove(f);
                }
            }
            freq.putIfAbsent(f+1, new TreeSet<>());
            freq.get(f+1).add(v);

            if (valid(freq)) {
                res = Math.max(res, i+1);
            }
        }
        return res;
    }

    private boolean valid(TreeMap<Integer, TreeSet<Integer>> freq) {
        if (freq.size() > 2) {
            return false;
        }
        if (freq.size() == 1) {
            if (freq.firstKey() == 1) {
                return true;
            }
            return freq.firstEntry().getValue().size() == 1;
        }
        // freq.size == 2
        int small = freq.firstKey(), big = freq.lastKey();
        if (freq.get(small).size() == 1 && small == 1) {
            return true;
        }
        if (freq.get(big).size() == 1 && small+1 == big) {
            return true;
        }
        return false;
    }
}
