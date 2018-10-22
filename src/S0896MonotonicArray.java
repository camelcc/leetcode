public class S0896MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) {
            return true;
        }
        Boolean increase = null;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                continue;
            } else if (A[i] > A[i-1]) {
                if (increase == null) {
                    increase = true;
                } else {
                    if (!increase) {
                        return false;
                    }
                }
            } else if (A[i] < A[i-1]) {
                if (increase == null) {
                    increase = false;
                } else {
                    if (increase) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
