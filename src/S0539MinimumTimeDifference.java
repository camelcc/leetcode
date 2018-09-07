import java.util.Arrays;
import java.util.List;

public class S0539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            times[i] = toMin(timePoints.get(i));
        }
        Arrays.sort(times);
        int prev = times[times.length - 1] - 24 * 60;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            int diff = times[i] - prev;
            if (diff < min) {
                min = diff;
            }
            prev = times[i];
        }

        return min;
    }

    private int toMin(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}
