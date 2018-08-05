import java.util.ArrayList;
import java.util.List;

public class S0241DifferentWaysAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        String arith = input.replaceAll(" ", "");

        List<Integer> vals = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= arith.length(); i++) {
            if (i == arith.length()) {
                vals.add(Integer.valueOf(sb.toString()));
                continue;
            }

            char c = arith.charAt(i);
            if (c == '+' || c ==  '-' || c == '*') {
                vals.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                ops.add(c);
            } else {
                sb.append(c);
            }
        }

        List<Integer> res = new ArrayList<>();
        cal(vals, ops, res);
        return res;
    }

    private void cal(List<Integer> vals, List<Character> ops, List<Integer> res) {
        if (ops.isEmpty()) {
            if (!res.contains(vals.get(0))) {
                res.add(vals.get(0));
            }
            return;
        }

        for (int i = 0; i < ops.size(); i++) {
            List<Character> opsClone = new ArrayList<>(ops);
            char op = opsClone.remove(i);
            List<Integer> valsClone = new ArrayList<>(vals);
            int v1 = valsClone.remove(i);
            int v2 = valsClone.remove(i);
            if (op == '+') {
                valsClone.add(i, v1 + v2);
            } else if (op == '-') {
                valsClone.add(i, v1 - v2);
            } else if (op == '*') {
                valsClone.add(i, v1 * v2);
            }

            cal(valsClone, opsClone, res);
        }
    }
}
