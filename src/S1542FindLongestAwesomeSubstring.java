import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1542FindLongestAwesomeSubstring {
    public int longestAwesome(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prev = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            prev ^= (1 << val);
            for (int j = 0; j <= 9; j++) {
                if (map.containsKey(prev ^ (1 << j))) {
                    res = Math.max(res, i - map.get(prev ^ (1 << j)));
                }
            }
            if (map.containsKey(prev)) {
                res = Math.max(res, i - map.get(prev));
            }
            map.putIfAbsent(prev, i);
        }
        return res;
    }
}
