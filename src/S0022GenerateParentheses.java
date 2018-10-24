import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0022GenerateParentheses {
    private HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("()");
            map.put(1, res);
            return res;
        }
        for (String s : generateParenthesis(n-1)) {
            res.add("("+s+")");
        }

        HashSet<String> combs = new HashSet<>();
        for (int i = 1; i < n; i++) {
            List<String> left = generateParenthesis(i);
            List<String> right = generateParenthesis(n-i);
            for (String l : left) {
                for (String r : right) {
                    combs.add(l+r);
                }
            }
        }
        res.addAll(combs);
        map.put(n, res);
        return res;
    }
}
