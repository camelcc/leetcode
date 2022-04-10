import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class S2231LargestNumberAfterDigitSwapsParity {
    public int largestInteger(int num) {
        List<Integer>[] digits = new ArrayList[2];
        digits[0] = new ArrayList<>();
        digits[1] = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        int v = num;
        while (v != 0) {
            int d = v%10;
            v = v/10;
            digits[d%2].add(d);
            stack.push(d);
        }
        digits[0].sort(Comparator.reverseOrder());
        digits[1].sort(Comparator.reverseOrder());
        int res = 0;
        int[] p = new int[2];
        while (!stack.isEmpty()) {
            int d = stack.pop();
            res = res * 10 + digits[d%2].get(p[d%2]++);
        }
        return res;
    }
}
