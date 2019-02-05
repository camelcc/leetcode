import java.util.Arrays;

public class S0718MaximumLengthRepeatedSubarray {
    private int[][] len;

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        len = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(len[i], -1);
        }
        int res = 0;
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                res = Math.max(res, len(A, a, B, b));
            }
        }
        return res;
    }

    private int len(int[] A, int ai, int[] B, int bi) {
        assert ai < A.length;
        assert bi < B.length;
        if (len[ai][bi] != -1) {
            return len[ai][bi];
        }

        int res = 0;
        if (A[ai] == B[bi]) {
            if (ai == A.length-1 || bi == B.length-1) {
                res = 1;
            } else {
                res = 1 + len(A, ai+1, B, bi+1);
            }
        }
        len[ai][bi] = res;
        return res;
    }
}
