public class S1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int N = A.length;
        int a = A[0], ca = 0, sa = 0, b = B[0], cb = 0, sb = 0;
        for (int i = 1; i < N && (a != -1 || b != -1); i++) {
            if (A[i] == a && B[i] == a) {
                sa++;
            }
            if (A[i] == b && B[i] == b) {
                sb++;
            }
            if (a != A[i] && a != B[i]) {
                a = -1;
            } else if (a != A[i]) {
                ca++;
            }
            if (b != A[i] && b != B[i]) {
                b = -1;
            } else if (b != B[i]) {
                cb++;
            }
        }
        ca = Math.min(ca, N-ca-sa);
        cb = Math.min(cb, N-cb-sb);
        if (a == -1 && b == -1) {
            return -1;
        } else if (a == -1) {
            return cb;
        } else if (b == -1) {
            return ca;
        } else {
            return Math.min(ca, cb);
        }
    }
}
