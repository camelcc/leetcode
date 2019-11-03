import java.util.Stack;

public class S1249MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                    String tmp = "";
                    if (!stack.isEmpty()) {
                        tmp = stack.pop();
                    }
                    tmp = tmp + '(' + sb.toString() + ')';
                    sb = new StringBuilder(tmp);
                }
            } else {
                sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
