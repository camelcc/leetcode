import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k == 0) {
            return new ArrayList<>();
        }

        int pos = Arrays.binarySearch(arr, x);
        if (pos < 0) {
            pos = -(pos+1);
        }
        if (pos >= arr.length || (pos > 0 && (x - arr[pos-1]) <= (arr[pos] - x))) {
            pos = pos-1;
        }
        List<Integer> res = new ArrayList<>();
        res.add(arr[pos]);

        int left = pos-1, right = pos+1;
        while (res.size() < k) {
            if (left < 0) {
                res.add(arr[right++]);
                continue;
            }
            if (right >= arr.length) {
                res.add(0, arr[left--]);
                continue;
            }
            if (x-arr[left] <= arr[right]-x) {
                res.add(0, arr[left--]);
            } else {
                res.add(arr[right++]);
            }
        }
        return res;
    }
}
