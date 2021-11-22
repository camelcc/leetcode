import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S2080RangeFrequencyQueries {
    public static class RangeFreqQuery {
        HashMap<Integer, ArrayList<Integer>> map;

        public RangeFreqQuery(int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int v = arr[i];
                if (!map.containsKey(v)) {
                    map.put(v, new ArrayList<>());
                }
                map.get(v).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value) || map.get(value).isEmpty()) {
                return 0;
            }
            ArrayList<Integer> pos = map.get(value);
            int l = Collections.binarySearch(pos, left);
            if (l < 0) {
                l = -(l+1);
            }
            int r = Collections.binarySearch(pos, right);
            if (r < 0) {
                r = -(r+1);
                r--;
            }
            return r-l+1;
        }
    }
}
