public class S1234ReplaceSubstringBalancedString {
    public int balancedString(String s) {
        int cnt = s.length()/4;
        int[] balanced = new int[4];
        for (char c : s.toCharArray()) {
            balanced[pos(c)]++;
        }
        for (int i = 0; i < 4; i++) {
            balanced[i] -= cnt;
        }
        if (good(balanced)) {
            return 0;
        }

        int res = s.length();
        int left = 0, pos = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            int p = pos(c);
            balanced[p]--;
            if (good(balanced)) {
                while (balanced[pos(s.charAt(left))]+1 <= 0) {
                    int lp = pos(s.charAt(left));
                    balanced[lp]++;
                    left++;
                }
                res = Math.min(res, pos-left+1);
            }
            pos++;
        }
        return res;
    }

    private int pos(char c) {
        if (c == 'Q') {
            return 0;
        } else if (c == 'W') {
            return 1;
        } else if (c == 'E') {
            return 2;
        } else if (c == 'R') {
            return 3;
        }
        return -1;
    }
    private boolean good(int[] balance) {
        if (balance[0] <= 0 && balance[1] <= 0 && balance[2] <= 0 && balance[3] <= 0) {
            return true;
        }
        return false;
    }
}
