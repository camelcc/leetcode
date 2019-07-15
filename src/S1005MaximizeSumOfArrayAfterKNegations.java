import java.util.Arrays;

public class S1005MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        if (A[0] >= 0) {
            A[0] = K%2 == 0 ? A[0] : -A[0];
        } else {
            int i = 0;
            while (i < A.length && K > 0 && A[i] < 0) {
                A[i] = -A[i];
                i++;
                K--;
            }
            if (K > 0) {
                Arrays.sort(A);
                A[0] = K%2 == 0 ? A[0] : -A[0];
            }
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        return sum;
    }
}
