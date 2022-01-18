import java.util.Arrays;

public class S2141MaximumRunningTimeNComputers {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }
        int N = batteries.length;
        int k = 0;
        while (batteries[N-1-k] > sum/(n-k)) {
            sum -= batteries[N-1-k];
            k++;
        }
        return sum/(n-k);
    }
}
