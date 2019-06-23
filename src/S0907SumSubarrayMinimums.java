import java.util.Stack;

public class S0907SumSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int MOD = (int)Math.pow(10, 9)+7;
        Stack<int[]> mins = new Stack<>();
        mins.push(new int[]{A[0], 1, A[0]});
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            int len = 1;
            while (!mins.isEmpty() && mins.peek()[0] >= A[i]) {
                len += mins.pop()[1];
            }
            int sum = A[i]*len;
            if (!mins.isEmpty()) {
                sum += mins.peek()[2];
            }
            res = (res + sum)%MOD;
            mins.push(new int[]{A[i], len, sum});
        }
        return res;
    }
}
