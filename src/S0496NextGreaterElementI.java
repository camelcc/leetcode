import java.util.HashMap;
import java.util.Stack;

public class S0496NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                greater.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greater.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
