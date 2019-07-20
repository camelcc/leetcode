import java.util.Stack;

public class S1047RemoveAllAdjacentDuplicatesString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            boolean dup = false;
            while (!stack.isEmpty() && stack.peek() == c) {
                dup = true;
                stack.pop();
            }
            if (!dup) {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
