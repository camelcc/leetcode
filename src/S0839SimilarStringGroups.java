public class S0839SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) {
                continue;
            }
            res++;
            dfs(A, i);
        }
        return res;
    }

    private void dfs(String[] A, int index) {
        assert A[index] != null;
        String word = A[index];
        A[index] = null;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) {
                continue;
            }

            if (similar(word, A[i])) {
                dfs(A, i);
            }
        }
    }

    private boolean similar(String a, String b) {
        assert a.length() == b.length();
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res <= 2;
    }
}
