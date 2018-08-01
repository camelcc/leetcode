import java.util.Stack;

public class S0227BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> vals = new Stack<>();
        Stack<Character> ops = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            int val;
            char c = ' ';
            if (i < s.length()) {
                c = s.charAt(i);
                if (!(c == '+' || c == '-' || c == '*' || c == '/')) {
                    if (c != ' ') {
                        sb.append(c);
                    }
                    continue;
                }
            }

            val = Integer.valueOf(sb.toString());
            if (!ops.isEmpty()) {
                if (ops.peek() == '*') {
                    ops.pop();
                    val = vals.pop() * val;
                } else if (ops.peek() == '/') {
                    ops.pop();
                    val = vals.pop() / val;
                }
            }
            if (!ops.isEmpty() && (c == '+' || c == '-' || i == s.length())) {
                assert ops.peek() == '+' || ops.peek() == '-';
                if (ops.peek() == '+') {
                    ops.pop();
                    val = vals.pop() + val;
                } else if (ops.peek() == '-') {
                    ops.pop();
                    val = vals.pop() - val;
                }
            }

            vals.push(val);
            ops.push(c);
            sb = new StringBuilder();
        }
        return vals.pop();
    }
}
