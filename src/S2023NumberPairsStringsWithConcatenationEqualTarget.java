import java.util.HashMap;

public class S2023NumberPairsStringsWithConcatenationEqualTarget {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String, Integer> cnt = new HashMap<>();
        int res = 0;
        for (String num : nums) {
            if (target.startsWith(num)) { // [num, sur]
                String t = target.substring(num.length());
                res += cnt.getOrDefault(t, 0);
            }
            if (target.endsWith(num)) {
                String t = target.substring(0, target.length()-num.length());
                res += cnt.getOrDefault(t, 0);
            }
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        return res;
    }
}
