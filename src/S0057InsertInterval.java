import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S0057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int p = Arrays.binarySearch(intervals, newInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0]-o2[0];
                } else {
                    return o1[1]-o2[1];
                }
            }
        });
        if (p < 0) {
            p = -(p+1);
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < p-1; i++) {
            res.add(intervals[i]);
        }

        int[] last = p > 0 ? intervals[p-1] : null;
        if (last == null) {
            last = newInterval;
        } else {
            if (newInterval[0] <= last[1]) {
                last[1] = Math.max(last[1], newInterval[1]);
            } else {
                res.add(last);
                last = newInterval;
            }
        }

        for (int i = p; i < intervals.length; i++) {
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                res.add(last);
                last = intervals[i];
            }
        }
        res.add(last);

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
