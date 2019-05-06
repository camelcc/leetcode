import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num.isEmpty()) {
            return new ArrayList<>();
        }
        char[] c = num.toCharArray();
        int[] digits = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            digits[i] = c[i]-'0';
        }

        HashMap<Integer, List<String>>[] dp = new HashMap[digits.length];
        for (int i = 0; i < digits.length; i++) {
            dp[i] = new HashMap<>();
        }
        return ops(digits, 0, target, dp);
    }

    private List<String> ops(int[] digits, int start, int target, HashMap<Integer, List<String>>[] dp) {
        if (dp[start].containsKey(target)) {
            return dp[start].get(target);
        }

        List<String> res = new ArrayList<>();
        if (start == digits.length-1) {
            if (digits[start] == target) {
                res.add(String.valueOf(digits[start]));
            }
        } else {
            // start < digits.len-1
            // +
            int t = target - digits[start];
            for (String r : ops(digits, start+1, t, dp)) {
                res.add(String.valueOf(digits[start] + "+" + r));
            }
            // -
            t = digits[start]-target;
            for (String r : ops(digits, start+1, t, dp)) {
                res.add(String.valueOf(digits[start]) + "-" + r);
            }
            // *
            StringBuilder sb = new StringBuilder();
            int d = digits[start];
            sb.append(String.valueOf(d));
            int i = start+1;
            while (i < digits.length) {
                d = d * digits[i];
                sb.append("*"+String.valueOf(digits[i]));
                if (i == digits.length-1) {
                    if (d == target) {
                        res.add(sb.toString());
                    }
                    break;
                }

                // +
                for (String r : ops(digits, i+1, target-d, dp)) {
                    res.add(sb.toString() + "+" + r);
                }
                // -
                for (String r : ops(digits, i+1, d-target, dp)) {
                    res.add(sb.toString() + "-" + r);
                }
                // *
                i++;
            }
        }
        dp[start].put(target, res);
        return res;
    }
}
