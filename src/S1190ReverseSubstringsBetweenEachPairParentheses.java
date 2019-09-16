import edu.princeton.cs.algs4.Stack;

public class S1190ReverseSubstringsBetweenEachPairParentheses {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current.toString());
                current = new StringBuilder();
            } else if (c == ')') {
                String t = current.reverse().toString();
                current = new StringBuilder();
                current.append(stack.pop());
                current.append(t);
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
