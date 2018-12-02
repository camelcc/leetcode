import java.util.Stack;

public class S0456_132Pattern {
    public boolean find132pattern(int[] nums) {
        // 1 < 3 > 2
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;

        for (int i = nums.length-1; i >= 0; i--) {
            int v = nums[i];
            if (v < s3) {
                return true;
            } else { // 1 >= 3
                while (!stack.isEmpty() && v > stack.peek()) {
                    s3 = stack.pop();
                }
            }

            stack.push(v);
        }
        return false;
    }
}
