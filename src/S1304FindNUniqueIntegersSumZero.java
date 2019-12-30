public class S1304FindNUniqueIntegersSumZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            int v = 1;
            for (int i = n/2; i < n; i++) {
                res[i] = v;
                v++;
            }
            v = -1;
            for (int i = n/2-1; i >= 0; i--) {
                res[i] = v;
                v--;
            }
        } else {
            int v = 1;
            for (int i = n/2+1; i < n; i++) {
                res[i] = v;
                v++;
            }
            v = -1;
            for (int i = n/2-1; i >= 0; i--) {
                res[i] = v;
                v--;
            }
        }
        return res;
    }
}
