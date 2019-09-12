import java.util.HashMap;
import java.util.TreeSet;

public class S1187MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> replace = new TreeSet<>();
        for (int t : arr2) {
            replace.add(t);
        }

        return make(arr1, arr1.length-1, replace, Integer.MAX_VALUE, new HashMap<>());
    }

    private int make(int[] arr, int index, TreeSet<Integer> replacement, int max, HashMap<String, Integer> dp) {
        if (index < 0) {
            return 0;
        }
        String key = index+","+max;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        Integer lower = replacement.lower(max);

        if (arr[index] >= max) {
            if (lower == null) {
                dp.put(key, -1);
                return -1;
            }
            // arr[index] = lower;
            int t = make(arr, index-1, replacement, lower, dp);
            if (t == -1) {
                dp.put(key, -1);
                return -1;
            } else {
                dp.put(key, 1+t);
                return 1 + t;
            }
        }
        // arr[index] < max
        int res = make(arr, index-1, replacement, arr[index], dp);
        // arr[index] = lower;
        if (lower != null) {
            int t = make(arr, index-1, replacement, lower, dp);
            if (t != -1) {
                if (res == -1) {
                    res = t+1;
                } else {
                    res = Math.min(res, t+1);
                }
            }
        }
        dp.put(key, res);
        return res;
    }
}
