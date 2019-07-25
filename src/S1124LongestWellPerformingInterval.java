import java.util.HashMap;

public class S1124LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> scores = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                res = i+1;
            } else {
                scores.putIfAbsent(sum, i);
                if (scores.containsKey(sum-1)) {
                    res = Math.max(res, i-scores.get(sum-1));
                }
            }
        }
        return res;
    }
}
