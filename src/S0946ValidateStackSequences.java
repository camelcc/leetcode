import java.util.Stack;

public class S0946ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < popped.length) {
            int v = popped[i];
            if (!stack.isEmpty() && stack.peek() == v) {
                stack.pop();
                i++;
                continue;
            }

            while (j < pushed.length && pushed[j] != v) {
                stack.push(pushed[j]);
                j++;
            }
            if (j == pushed.length) {
                return false;
            }

            i++;
            j++;
        }
        return true;
    }
}
