import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/steps-to-make-array-non-decreasing/discuss/2085967/python-Explanation-with-pictures
// https://leetcode.com/problems/steps-to-make-array-non-decreasing/discuss/2086172/DP-%2B-finding-last-greater-element-using-stack
public class S2289StepsMakeArrayNondecreasing {
    public int totalSteps(int[] nums) {
        int res = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int steps = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                steps = Math.max(steps, stack.peek()[1]+1);
                stack.pop();
            }
            if (stack.isEmpty()) {
                steps = 0;
            }
            res = Math.max(res, steps);
            stack.push(new int[]{nums[i], steps});
        }
        return res;
    }
}
