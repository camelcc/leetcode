import edu.princeton.cs.algs4.Stack;

public class S0020ValidParentheses {
    // ()[]{}
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> symbols = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                symbols.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (symbols.isEmpty()) {
                    return false;
                }
                char p = symbols.pop();
                if (!((c == ')' && p == '(') || (c == ']' && p == '[') || (c == '}' && p == '{'))) {
                    return false;
                }
            }
        }
        return symbols.isEmpty();
    }
}
