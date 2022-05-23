import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2061985/Python-Solution-O(n)
public class S2281SumTotalStrengthWizards {
    public int totalStrength(int[] strength) {
        int MOD = 1_000_000_007;
        int N = strength.length;

        int[] right = new int[N];
        Arrays.fill(right, N);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        int[] left = new int[N];
        Arrays.fill(left, -1);
        stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        long res = 0;
        long[] preSum = new long[N];
        for (int i = 0; i < N; i++) {
            preSum[i] = i == 0 ? strength[i] : preSum[i-1]+strength[i];
        }
        long[] preSumPreSum = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            preSumPreSum[i] = (preSumPreSum[i - 1] + preSum[i - 1]) % MOD;
        }
        for (int i = 0; i < N; i++) {
            int l = left[i];
            int r = right[i];
            long lSum = preSumPreSum[i] - preSumPreSum[Math.max(l, 0)];
            long rSum = preSumPreSum[r] - preSumPreSum[i];
            res = (res + strength[i] * (rSum * (i - l) % MOD - lSum * (r - i) % MOD)) % MOD;
        }
        return (int) (res + MOD) % MOD;
    }
}
