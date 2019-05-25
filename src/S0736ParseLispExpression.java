import java.util.HashMap;
import java.util.Stack;

public class S0736ParseLispExpression {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String expr, HashMap<String, Integer> scope) {
        expr = expr.trim();
        assert !expr.isEmpty();
        if (!expr.startsWith("(")) {
            if (Character.isLowerCase(expr.charAt(0))) {
                return scope.get(expr);
            } else {
                return Integer.valueOf(expr);
            }
        }

        assert expr.endsWith(")");
        String inner = expr.substring(1, expr.length()-1).trim();
        if (inner.startsWith("add") || inner.startsWith("mult")) {
            boolean add = inner.startsWith("add");
            inner = inner.substring(4).trim();

            String le = readNext(inner);
            assert !le.isEmpty();
            int l = evaluate(le, scope);
            inner = inner.substring(le.length()).trim();
            assert !inner.isEmpty();
            String re = readNext(inner);
            assert !re.isEmpty();
            int r = evaluate(re, scope);
            inner = inner.substring(re.length()).trim();
            assert inner.isEmpty();

            if (add) {
                return l+r;
            } else {
                return l*r;
            }
        } else if (inner.startsWith("let")) {
            inner = inner.substring(3).trim();
            HashMap<String, Integer> innerScope = new HashMap<>(scope);
            String ex = "";
            while (!inner.isEmpty()) {
                String vs = readNext(inner);
                assert !vs.isEmpty();
                inner = inner.substring(vs.length()).trim();
                if (inner.isEmpty()) { // last
                    ex = vs;
                    continue;
                }
                String es = readNext(inner);
                assert !es.isEmpty();
                inner = inner.substring(es.length()).trim();
                assert !inner.isEmpty();
                int v = evaluate(es, innerScope);
                innerScope.put(vs, v);
            }
            assert !ex.isEmpty();
            return evaluate(ex, innerScope);
        } else {
            return evaluate(inner, scope);
        }
    }

    private String readNext(String expr) {
        expr = expr.trim();
        if (!expr.startsWith("(")) {
            int p = expr.indexOf(' ');
            if (p >= 0) {
                return expr.substring(0, p);
            } else {
                return expr;
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            sb.append(c);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
