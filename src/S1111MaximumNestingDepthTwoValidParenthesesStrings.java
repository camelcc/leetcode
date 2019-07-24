import java.util.Arrays;

public class S1111MaximumNestingDepthTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        Arrays.fill(res, -1);
        min(seq.toCharArray(), res, 0, seq.length()-1, true);
        return res;
    }

    private void min(char[] seq, int[] res, int start, int end, boolean a) {
        assert seq[start] == '(' && seq[end] == ')';
        int p = start;
        while (p <= end) {
            assert seq[p] == '(';
            int l = p;
            p++;
            int left = 1;
            while (left != 0) {
                if (seq[p] == '(') {
                    left++;
                } else if (seq[p] == ')') {
                    left--;
                }
                p++;
            }
            int r = p-1;
            res[l] = a ? 0 : 1;
            res[r] = a ? 0 : 1;
            if (l+1 < r-1) {
                min(seq, res, l+1, r-1, !a);
            }
        }
    }
}
