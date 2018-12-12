import java.util.Arrays;
import java.util.Stack;

public class S0503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length == 0) {
            return res;
        }
        int mv = nums[0], mi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mv <= nums[i]) {
                mv = nums[i];
                mi = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = mi+1; i < mi+1+nums.length; i++) {
            int v = nums[i%nums.length];
            while (!stack.isEmpty() && nums[stack.peek()%nums.length] < v) {
                res[stack.peek()%nums.length] = v;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
