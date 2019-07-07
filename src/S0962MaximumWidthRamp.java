import java.util.Arrays;
import java.util.Stack;

public class S0962MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i)
            if (s.empty() || A[s.peek()] > A[i])
                s.add(i);
        for (int i = n - 1; i > res; --i)
            while (!s.empty() && A[s.peek()] <= A[i])
                res = Math.max(res, i - s.pop());
        return res;
    }
}
