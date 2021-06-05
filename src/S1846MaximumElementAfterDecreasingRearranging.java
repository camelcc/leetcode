import java.util.Arrays;

public class S1846MaximumElementAfterDecreasingRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int cur = 0;
        for (int a : arr) {
            cur++;
            cur = Math.min(cur, a);
        }
        return cur;
    }
}
