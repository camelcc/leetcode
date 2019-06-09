import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class S0032LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> unpaired = new Stack<>();
        unpaired.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                unpaired.push(i);
            } else { // )
                assert c == ')';
                unpaired.pop();
                if (unpaired.isEmpty()) {
                    unpaired.push(i);
                } else {
                    res = Math.max(res, i-unpaired.peek());
                }
            }
        }
        return res;
    }
}
