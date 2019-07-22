public class S1053PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int i = A.length-2;
        while (i >= 0 && A[i] <= A[i+1]) {
            i--;
        }
        if (i < 0) {
            return A;
        }
        int j = i+1;
        while (j < A.length && A[j] < A[i]) {
            j++;
        }
        j--;
        while (j > i && A[j] == A[j-1]) {
            j--;
        }
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
        return A;
    }
}
