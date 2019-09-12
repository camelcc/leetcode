public class S1186MaximumSubarraySumOneDeletion {
    public int maximumSum(int[] arr) {
        int res = arr[0];
        int preSum = arr[0], preDeletedSum = 0;
        for (int i = 1; i < arr.length; i++) {
            preDeletedSum = Math.max(preSum, preDeletedSum+arr[i]);
            preSum = Math.max(preSum+arr[i], arr[i]);
            res = Math.max(res, Math.max(preDeletedSum, preSum));
        }
        return res;
    }
}
