public class S0960DeleteColumnsMakeSortedIII {
    public int minDeletionSize(String[] A) {
        int N = A[0].length();
        int[] dp = new int[N];
        for (int i = N-2; i >= 0; i--) {
            int res = N-i-1;
            for (int j = i+1; j < N && j-i-1 < res; j++) {
                if (less(A, i, j)) {
                    res = Math.min(res, dp[j]+j-i-1);
                }
            }
            dp[i] = res;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            res = Math.min(res, i+dp[i]);
        }
        return res;
    }

    private boolean less(String[] A, int i, int j) {
        for (String a : A) {
            if (a.charAt(i) > a.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
