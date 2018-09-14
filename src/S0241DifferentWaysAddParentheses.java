import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0241DifferentWaysAddParentheses {
    HashMap<String, List<Integer>> vals = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        String arith = input.replaceAll(" ", "");
        HashMap<String, List<Integer>> map = new HashMap<>();
        return cal(arith, map);
    }

    private List<Integer> cal(String arith, HashMap<String, List<Integer>> map) {
        if (map.containsKey(arith)) {
            return map.get(arith);
        }
        List<Integer> res = new ArrayList<>();
        if (!(arith.contains("+") || arith.contains("-") || arith.contains("*"))) {
            res.add(Integer.valueOf(arith));
            map.put(arith, res);
            return res;
        }

        for (int i = 0; i < arith.length(); i++) {
            char c = arith.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = arith.substring(0, i);
                String right = arith.substring(i+1);
                List<Integer> lv = cal(left, map);
                List<Integer> rv = cal(right, map);
                for (int l : lv) {
                    for (int r : rv) {
                        int val = 0;
                        if (c == '+') {
                            val = l + r;
                        } else if (c == '-') {
                            val = l - r;
                        } else if (c == '*') {
                            val = l * r;
                        }
                        res.add(val);
                    }
                }
            }
        }

        map.put(arith, res);
        return res;
    }
}
