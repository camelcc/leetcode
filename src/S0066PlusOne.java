import java.util.Stack;

public class S0066PlusOne {
    public int[] plusOne(int[] digits) {
        Stack<Integer> sum = new Stack<>();
        int added = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (added == 0) {
                sum.push(digits[i]);
                continue;
            }

            int s = digits[i] + added;
            if (s >= 10) {
                sum.push(s-10);
                added = 1;
            } else {
                sum.push(s);
                added = 0;
            }
        }
        if (added == 1) {
            sum.push(added);
        }
        int i = 0;
        int[] res = new int[sum.size()];
        while (!sum.empty()) {
            res[i++] = sum.pop();
        }
        return res;
    }

}
