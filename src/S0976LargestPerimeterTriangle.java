import java.util.Arrays;

public class S0976LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int c = A.length-1; c >= 2; c--) {
            if (A[c] < A[c-1]+A[c-2]) {
                return A[c]+A[c-1]+A[c-2];
            }
        }
        return 0;
    }
}
