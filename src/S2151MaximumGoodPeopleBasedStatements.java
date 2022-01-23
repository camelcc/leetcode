public class S2151MaximumGoodPeopleBasedStatements {
    public int maximumGood(int[][] statements) {
        int N = statements.length;
        int res = 0;
        for (int i = 0; i < (0x1<<N); i++) {
            if (valid(statements, i)) {
                int t = i, r = 0;
                while (t > 0) {
                    if (t%2 == 1) {
                        r++;
                    }
                    t = t/2;
                }
                res = Math.max(res, r);
            }
        }
        return res;
    }

    private boolean valid(int[][] statements, int state) {
        int N = statements.length;
        for (int i = 0; i < N; i++) {
            // 1 - good, 0 - bad, 2 - bad truth, 3 - bad lie
            if (!good(state, i)) {
                continue;
            }
            for (int j = 0; j < N; j++) {
                if (statements[i][j] == 2) {
                    continue;
                }
                boolean truth = (statements[i][j] == 0 && !good(state, j)) ||
                        (statements[i][j] == 1 && good(state, j));
                if (!truth) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean good(int state, int i) {
        return (state>>i)%2 == 1;
    }
}
