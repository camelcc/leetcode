import java.util.Arrays;

public class S1619MeanArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int l = len/20;
        int r = len-l;
        double res = 0;
        for (int i = l; i < r; i++) {
            res += arr[i];
        }
        res = res/(r-l);
        return res;
    }
}
