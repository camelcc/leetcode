import java.util.Arrays;

public class S1300SumMutatedArrayClosestTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] sum = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            sum[i+1] = sum[i]+arr[i];
        }
        if (sum[arr.length] <= target) {
            return arr[arr.length-1];
        }

        int lo = 0, hi = arr[arr.length-1];
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -(index+1);
            }
            int t = sum[index]+(arr.length-index)*mid;
            if (t < target) {
                if (lo == mid) {
                    break;
                }
                lo = mid;
            } else if (t == target) {
                return mid;
            } else { // t > target
                hi = mid;
            }
        }
        // lo
        int li = Arrays.binarySearch(arr, lo);
        if (li < 0) {
            li = -(li+1);
        }
        int dlo = Math.abs(sum[li]+(arr.length-li)*lo-target);
        int ih = Arrays.binarySearch(arr, lo+1);
        if (ih < 0) {
            ih = -(ih+1);
        }
        int dhi = Math.abs(sum[ih]+(arr.length-ih)*(lo+1)-target);
        if (dlo <= dhi) {
            return lo;
        } else {
            return lo+1;
        }
    }
}
