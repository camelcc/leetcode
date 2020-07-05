import java.util.Arrays;

public class S1503LastMomentBeforeAllAntsFallOutPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        if (left.length > 0) {
            Arrays.sort(left);
            res = Math.max(res, left[left.length-1]);
        }
        if (right.length > 0) {
            Arrays.sort(right);
            res = Math.max(res, n-right[0]);
        }
        return res;
    }
}
