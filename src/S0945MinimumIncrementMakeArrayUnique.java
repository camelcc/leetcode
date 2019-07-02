import java.util.Arrays;

public class S0945MinimumIncrementMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]+1) {
                res += A[i-1]+1-A[i];
                A[i] = A[i-1]+1;
            }
        }
        return res;
    }
}
