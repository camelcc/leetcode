import java.util.Arrays;

public class S0454_4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int i = 0;
        int[] ab = new int[A.length * B.length];
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                ab[i++] = A[a] + B[b];
            }
        }
        i = 0;
        int[] cd = new int[C.length * D.length];
        for (int c = 0; c < C.length; c++) {
            for (int d = 0; d < D.length; d++) {
                cd[i++] = C[c] + D[d];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int cnt = 0;
        for (i = 0;  i < ab.length; i++) {
            int ra = 0-ab[i];
            int index = Arrays.binarySearch(cd, ra);
            if (index < 0) {
                continue;
            }

            int c = 1;
            int j = index;
            while (j > 0 && cd[j] == cd[j-1]) {
                j = j - 1;
                c++;
            }
            j = index;
            while (j < cd.length-1 && cd[j] == cd[j+1]) {
                j = j + 1;
                c++;
            }

            cnt += c;
        }
        return cnt;
    }
}
