import java.util.Arrays;

public class S0891SumSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        int MOD = (int)Math.pow(10, 9)+7;
        Arrays.sort(A);
        long res = 0;
        long left = 1;
        for (int i = 0; i < A.length; i++) {
            res = (res + left*(A[i]-A[A.length-i-1]))%MOD;
            left = (left << 1)%MOD;
        }
        return (int)(res+MOD)%MOD;
    }
}
