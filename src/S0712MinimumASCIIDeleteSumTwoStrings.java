public class S0712MinimumASCIIDeleteSumTwoStrings {
    int[][] minSum;

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return 0;
        }
        minSum = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                minSum[i][j] = -1;
            }
        }
        return minDeleteSum(s1, 0, s2, 0);
    }

    private int minDeleteSum(String s1, int i1, String s2, int i2) {
        int res = 0;
        if (i1 == s1.length() && i2 == s2.length()) {
            return res;
        }
        if (i1 == s1.length()) {
            return s2.charAt(i2) + minDeleteSum(s1, i1, s2, i2 + 1);
        } else if (i2 == s2.length()) {
            return s1.charAt(i1) + minDeleteSum(s1, i1+1, s2, i2);
        }
        assert i1 < s1.length();
        assert i2 < s2.length();

        if (minSum[i1][i2] != -1) {
            return minSum[i1][i2];
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            res = minDeleteSum(s1, i1+1, s2, i2+1);
        } else {
            res = Math.min(s1.charAt(i1) + minDeleteSum(s1, i1+1, s2, i2),
                    s2.charAt(i2) + minDeleteSum(s1, i1, s2, i2+1));
        }
        minSum[i1][i2] = res;
        return res;
    }
}
