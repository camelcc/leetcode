import java.util.ArrayList;
import java.util.List;

public class S0282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        return ops(num, target, "", 0, 0);
    }

    private List<String> ops(String num, int target, String str, int val, int last) {
        List<String> res = new ArrayList<>();
        if (num.isEmpty()) {
            if (val == target) {
                res.add(str);
            }
            return res;
        }

        if (num.startsWith("0")) {
            String remains = num.substring(1);
            // +
            res.addAll(ops(remains, target, str.isEmpty() ? "0" : str + "+0", val, 0));
            if (str.isEmpty()) {
                return res;
            }
            // -
            res.addAll(ops(remains, target, str + "-0", val, 0));
            // *
            res.addAll(ops(remains, target, str + "*0", (val-last), 0));
            return res;
        }

        for (int i = 0; i < num.length(); i++) {
            int current;
            try {
                current = Integer.valueOf(num.substring(0, i+1));
            } catch (NumberFormatException e) {
                continue;
            }

            String remains = num.substring(i+1);
            // +
            res.addAll(ops(remains, target, str.isEmpty() ? String.valueOf(current) : str + "+" + String.valueOf(current), val+current, current));
            if (str.isEmpty()) {
                continue;
            }
            // -
            res.addAll(ops(remains, target, str + "-" + String.valueOf(current), val-current, -current));
            // *
            res.addAll(ops(remains, target, str + "*" + String.valueOf(current), (val-last+(last*current)), last*current));
        }
        return res;
    }
}
