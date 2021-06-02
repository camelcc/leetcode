public class S1806MinimumNumberOperationsReinitializePermutation {
    public int reinitializePermutation(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        int res = 0;
        while (true) {
            res++;
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                if (i%2 == 0) {
                    next[i] = data[i/2];
                } else { // 1
                    next[i] = data[n/2+(i-1)/2];
                }
            }
            data = next;
            if (valid(data)) {
                return res;
            }
        }
    }

    private boolean valid(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != i) {
                return false;
            }
        }
        return true;
    }
}
