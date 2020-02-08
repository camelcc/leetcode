public class S1343NumberSubarraysSizeKAverageGreaterEqualThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int[] pre = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre[i] = sum;

            if (i >= k-1) {
                if (sum - ((i-k) >= 0 ? pre[i-k] : 0) >= k*threshold) {
                    res++;
                }
            }
        }
        return res;
    }
}
