import java.util.*;

public class S1353MaximumNumberEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (int[] a, int[] b) -> {
            if (a[1] != b[1]) {
                return a[1]-b[1];
            }
            return a[0]-b[1];
        });

        HashSet<Integer> days = new HashSet<>();
        for (int[] e : events) {
            for(int i = e[0]; i <= e[1]; i++) {
                if(!days.contains(i)) {
                    days.add(i);
                    break;
                }
            }
        }
        return days.size();
    }
}
