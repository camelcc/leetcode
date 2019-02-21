public class S0775GlobalLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 1) {
            return true;
        }
        int i = 1;
        while (i < A.length) {
            if (A[i] < A[i-1]) {
                int t = A[i-1];
                A[i-1] = A[i];
                A[i] = t;
                i+=2;
            } else {
                i++;
            }
        }

        i = 1;
        while (i < A.length) {
            if (A[i] < A[i-1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
