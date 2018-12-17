import java.util.HashMap;

public class S0525ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int v = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                v--;
            } else if (nums[i] == 1) {
                v++;
            }

            if (map.containsKey(v)) {
                int len = i - map.get(v);
                if (len > res) {
                    res = len;
                }
            } else {
                map.put(v, i);
            }
        }
        return res;
    }
}
