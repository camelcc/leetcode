public class S0961NRepeatedElementSize2NArray {
    public int repeatedNTimes(int[] A) {
        int a = A[0], b = A[1], c = A[2];
        if (a == b || a == c) {
            return a;
        } else if (b == c) {
            return b;
        }
        for (int i = 3; i < A.length; i++) {
            int v = A[i];
            if (v == a || v == b || v == c) {
                return v;
            }
            a = b;
            b = c;
            c = v;
        }
        return -1;
    }
}
