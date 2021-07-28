import java.util.HashMap;
import java.util.Stack;

public class S1944NumberVisiblePeopleQueue {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for (int i = heights.length-1; i >= 0; i--) {
            int h = heights[i];
            int c = 0;
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(h);
        }
        return res;
    }
}
