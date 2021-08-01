import java.util.Arrays;

public class S1953MaximumNumberWeeksWhichYouCanWork {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for (int m : milestones) {
            max = Math.max(max, m);
            sum += m;
        }
        if (max > sum-max) {
            return 2*(sum-max)+1;
        } else {
            return sum;
        }
    }
}
