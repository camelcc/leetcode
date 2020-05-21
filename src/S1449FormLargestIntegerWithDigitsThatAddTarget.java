import java.util.HashMap;

public class S1449FormLargestIntegerWithDigitsThatAddTarget {
    public String largestNumber(int[] cost, int target) {
        return largest(cost, target, new HashMap<>());
    }

    private String largest(int[] cost, int remains, HashMap<Integer, String> dp) {
        if (dp.containsKey(remains)) {
            return dp.get(remains);
        }

        String res = "0";
        for (int d = 1; d <= 9; d++) {
            if (cost[d-1] == remains) {
                if (compare(res, String.valueOf(d)) < 0) {
                    res = String.valueOf(d);
                }
            } else if (cost[d-1] < remains) { // cost[d] < remains
                String r = largest(cost, remains-cost[d-1], dp);
                if (!r.equals("0")) {
                    String c = d + r;
                    if (compare(res, c) < 0) {
                        res = c;
                    }
                }
            }
        }
        dp.put(remains, res);
        return res;
    }

    private int compare(String a, String b) {
        if (a.length() > b.length()) {
            return 1;
        }
        if (a.length() < b.length()) {
            return -1;
        }
        // a.len == b.len
        for (int i = 0; i < a.length(); i++) {
            int da = a.charAt(i)-'0';
            int db = b.charAt(i)-'0';
            if (da < db) {
                return -1;
            } else if (da > db) {
                return 1;
            }
        }
        return 0;
    }
}
