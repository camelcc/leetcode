import java.util.Arrays;
import java.util.HashMap;

public class S2007FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length == 0 || changed.length%2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] res = new int[changed.length/2];
        int p = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = changed.length-1; i >= 0; i--) {
            int upper = changed[i]*2;
            if (cnt.containsKey(upper)) {
                if (cnt.get(upper) == 1) {
                    cnt.remove(upper);
                } else {
                    cnt.put(upper, cnt.get(upper)-1);
                }
            } else {
                if (changed[i]%2 != 0) {
                    return new int[0];
                }
                cnt.put(changed[i], cnt.getOrDefault(changed[i], 0)+1);
                if (p >= res.length) {
                    return new int[0];
                }
                res[p++] = changed[i]/2;
            }
        }
        if (!cnt.isEmpty()) {
            return new int[0];
        }
        return res;
    }
}
