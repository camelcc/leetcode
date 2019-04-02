import java.util.Stack;

public class S0856ScoreParentheses {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else if (c == ')') {
                int val = 0;
                int v = stack.pop();
                while (v != 0) {
                    val += v;
                    v = stack.pop();
                }
                if (val == 0) {
                    val = 1;
                } else {
                    val = val * 2;
                }
                stack.push(val);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
