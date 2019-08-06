import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        HashSet<String> res = new HashSet<>();
        if (n == 1) {
            res.add("()");
        } else {
            for (String t : generateParenthesis(n-1)) {
                res.add("("+t+")");
            }
            for (int l = 1; l < n; l++) {
                List<String> left = generateParenthesis(l);
                List<String> right = generateParenthesis(n-l);
                for (String ls : left) {
                    for (String rs : right) {
                        res.add(ls+rs);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
