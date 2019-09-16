public class S1191KConcatenationMaximumSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = (int)Math.pow(10, 9)+7;
        long total = sum(arr), pre = preSum(arr), sur = surSum(arr), sub = subSum(arr);
        if (total > 0) {
            return (int)(Math.max(pre + (k-2)*total + sur, sub)%MOD);
        } else {
            return (int)(Math.max(pre + sur, sub)%MOD);
        }
    }

    private int sum(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    private int preSum(int[] arr) {
        int sum = 0, pre = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre = Math.max(pre, sum);
        }
        return pre;
    }

    private int surSum(int[] arr) {
        int sum = 0, sur = Integer.MIN_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            sum += arr[i];
            sur = Math.max(sur, sum);
        }
        return sur;
    }

    private int subSum(int[] arr) {
        int sum = 0, current = 0;
        for (int i = 0; i < arr.length; i++) {
            current = Math.max(current+arr[i], arr[i]);
            sum = Math.max(current, sum);
        }
        return sum;
    }
}
