import java.util.Stack;

public class S0150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("invalid");
        }

        Stack<Integer> vals = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int second = vals.pop();
                int first = vals.pop();
                vals.push(first + second);
            } else if (t.equals("-")) {
                int second = vals.pop();
                int first = vals.pop();
                vals.push(first - second);
            } else if (t.equals("*")) {
                int second = vals.pop();
                int first = vals.pop();
                vals.push(first * second);
            } else if (t.equals("/")) {
                int second = vals.pop();
                int first = vals.pop();
                vals.push(first / second);
            } else {
                vals.add(Integer.valueOf(t));
            }
        }

        assert vals.size() > 0;
        return vals.pop();
    }
}
