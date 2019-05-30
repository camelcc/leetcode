import java.util.Arrays;

public class S0805SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        // S(A)*L = S*L(A)
        for (int len = 1; len <= A.length/2; len++) {
            if ((sum*len)%N != 0) {
                continue;
            }
            if (sum(A, sum*len/N, len, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean sum(int[] A, int sum, int len, int startIndex) {
        assert len > 0;
        if (len == 1) {
            return Arrays.binarySearch(A, startIndex, A.length, sum) >= 0;
        }
        for (int i = startIndex; i < A.length && A[i] < sum; i++) {
            if (i > startIndex && A[i] == A[i-1]) {
                continue;
            }
            if (sum(A, sum-A[i], len-1, i+1)) {
                return true;
            }
        }
        return false;
    }
}
