import java.util.Arrays;
import java.util.Stack;

public class S0757SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] >= intervals[i][1]) {
                stack.pop();
            }
            stack.push(intervals[i]);
        }
        intervals = new int[stack.size()][2];
        for (int i = intervals.length-1; i >= 0; i--) {
            int[] t = stack.pop();
            intervals[i][0] = t[0];
            intervals[i][1] = t[1];
        }

        int res = 2;
        int prev1 = intervals[0][1]-1;
        int prev2 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            boolean canUsePrev1 = prev1 >= intervals[i][0] && prev1 <= intervals[i][1];
            boolean canUsePrev2 = prev2 >= intervals[i][0] && prev2 <= intervals[i][1];
            if (canUsePrev1 && canUsePrev2) {
                continue;
            }

            assert !canUsePrev1;

            if (canUsePrev2) {
                prev1 = prev2;
                prev2 = intervals[i][1];
                res++;
                continue;
            }

            prev1 = intervals[i][1]-1;
            prev2 = intervals[i][1];
            res += 2;
        }

        return res;
    }
}
