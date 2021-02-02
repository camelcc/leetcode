import java.util.Arrays;

public class S1508RangeSumSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sum = new int[n*(n+1)/2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j < n; j++) {
                s += nums[j];

                sum[k++] = s;
            }
        }
        Arrays.sort(sum);
        long res = 0;
        for (int i = left-1; i < right; i++) {
            res += sum[i];
        }
        return (int)(res%(Math.pow(10, 9)+7));
    }
}
