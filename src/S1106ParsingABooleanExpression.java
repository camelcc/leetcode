import java.util.ArrayList;
import java.util.List;

public class S1106ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        return parse(expression).get(0);
    }

    private List<Boolean> parse(String expression) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '!' || c == '&' || c == '|') {
                assert expression.charAt(i+1) == '(';
                int p = i+2, left = 1;
                while (left != 0) {
                    if(expression.charAt(p) == '(') {
                        left++;
                    } else if (expression.charAt(p) == ')') {
                        left--;
                    }
                    p++;
                }
                List<Boolean> r = parse(expression.substring(i+2, p-1));
                if (c == '!') {
                    assert r.size() == 1;
                    res.add(!r.get(0));
                } else if (c == '&') {
                    boolean t = true;
                    for (boolean b : r) {
                        t = t&b;
                    }
                    res.add(t);
                } else if (c == '|') {
                    boolean t = false;
                    for (boolean b : r) {
                        t = t|b;
                    }
                    res.add(t);
                }
                i = p-1;
            } else if (c == ',') {
            } else if (c == 't') {
                res.add(true);
            } else if (c == 'f') {
                res.add(false);
            }
        }
        return res;
    }
}
