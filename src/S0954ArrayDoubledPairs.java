import java.util.Arrays;

public class S0954ArrayDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        boolean[] visited = new boolean[A.length];
        int lo = 0, hi = 1, len = 0;
        while (len < A.length/2) {
            while (lo < A.length && visited[lo]) {
                lo++;
            }
            if (lo >= A.length) {
                return false;
            }
            int v = 2*A[lo];
            if (A[lo] < 0) {
                if (A[lo]%2 != 0) {
                    return false;
                }
                v = A[lo]/2;
            }
            visited[lo] = true;
            if (hi == lo) {
                hi++;
            }
            if (hi >= A.length) {
                return false;
            }
            hi = search(A, hi, A.length-1, v);
            if (hi == -1) {
                return false;
            }
            visited[hi] = true;
            lo++;
            hi++;
            len++;
        }
        return true;
    }

    private int search(int[] A, int lo, int hi, int v) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] < v) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        if (A[lo] == v) {
            return lo;
        } else {
            return -1;
        }
    }
}
