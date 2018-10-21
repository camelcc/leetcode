import java.util.Arrays;

public class S0888FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sa = 0, sb = 0;
        for (int n : A) {
            sa += n;
        }
        for (int n : B) {
            sb += n;
        }
        int d = (sb -sa)/2;
        for (int n : A) {
            if (Arrays.binarySearch(B, n+d) >= 0) {
                return new int[]{n, n+d};
            }
        }
        return null;
    }
}
