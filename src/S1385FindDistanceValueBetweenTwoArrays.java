import java.util.Arrays;

public class S1385FindDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int v : arr1) {
            int i = Arrays.binarySearch(arr2, v);
            if (i >= 0) {
                continue;
            }
            i = -(i+1);
            if (i > 0 && v-arr2[i-1] <= d) {
                continue;
            }
            if (i < arr2.length && arr2[i]-v <= d) {
                continue;
            }
            res++;
        }
        return res;
    }
}
