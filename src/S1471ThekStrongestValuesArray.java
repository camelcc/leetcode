import java.util.Arrays;

public class S1471ThekStrongestValuesArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = arr[(arr.length-1)/2];
        int[] res = new int[k];
        int i = 0, li = 0, ri = arr.length-1;
        while (i < k) {
            if (median-arr[li] > arr[ri]-median) {
                res[i] = arr[li++];
            } else {
                res[i] = arr[ri--];
            }
            i++;
        }
        return res;
    }
}
