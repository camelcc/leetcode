import java.util.Stack;

public class S0678ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        return check(s.toCharArray(), 0, left);
    }

    private boolean check(char[] chars, int index, Stack<Integer> parenthesis) {
        if (index == chars.length) {
            return parenthesis.isEmpty();
        }

        char c = chars[index];
        if (c == '(') {
            parenthesis.push(index);
            return check(chars, index+1, parenthesis);
        } else if (c == ')') {
            if (parenthesis.isEmpty()) {
                return false;
            }
            parenthesis.pop();
            return check(chars, index+1, parenthesis);
        } else if (c == '*') {
            // empty
            Stack<Integer> t1 = new Stack<>();
            t1.addAll(parenthesis);
            if (check(chars, index+1, t1)) {
                return true;
            }
            // left
            Stack<Integer> t2 = new Stack<>();
            t2.addAll(parenthesis);
            t2.push(index);
            if (check(chars, index+1, t2)) {
                return true;
            }
            // right
            Stack<Integer> t3 = new Stack<>();
            t3.addAll(parenthesis);
            if (!t3.isEmpty()) {
                t3.pop();
                if (check(chars, index + 1, t3)) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("invalid char");
        }
    }
}
