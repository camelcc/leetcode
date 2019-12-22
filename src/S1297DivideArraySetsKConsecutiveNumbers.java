import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

public class S1297DivideArraySetsKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        while (!map.isEmpty()) {
            int l = map.firstKey();
            int cnt = map.get(l);
            for (int n = l; n < l+k; n++) {
                int c = map.getOrDefault(n, 0);
                if (c < cnt) {
                    return false;
                } else if (c == cnt) {
                    map.remove(n);
                } else {
                    map.put(n, c-cnt);
                }
            }
        }
        return true;
    }
}
