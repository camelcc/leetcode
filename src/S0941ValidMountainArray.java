public class S0941ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2 || A[0] >= A[1]) {
            return false;
        }

        boolean up = true;
        int i = 1;
        while (i < A.length) {
            if (A[i] < A[i-1]) {
                if (up) {
                    up = false;
                }
            } else if (A[i] == A[i-1]) {
                return false;
            } else if (A[i] > A[i-1]) {
                if (!up) {
                    return false;
                }
            }
            i++;
        }
        return !up;
    }
}
