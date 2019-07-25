import java.util.Arrays;

public class S1131MaximumAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;
        int[] max = new int[4];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 0; i < arr1.length; i++) {
            int[] v = new int[]{arr1[i]+arr2[i]-i, arr1[i]-arr2[i]-i, -arr1[i]+arr2[i]-i, -arr1[i]-arr2[i]-i};
            for (int t = 0; t < 4; t++) {
                max[t] = Math.max(max[t], v[t]);
                min[t] = Math.min(min[t], v[t]);
                res = Math.max(res, max[t]-min[t]);
            }
        }
        return res;
    }
}
