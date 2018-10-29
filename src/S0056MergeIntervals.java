import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S0056MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            return res;
        }

        Interval[] inters = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(inters, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        Interval current = new Interval(inters[0].start, inters[0].end);
        for (int i = 1; i < inters.length; i++) {
            Interval inter = inters[i];
            if (inter.start <= current.end) {
                current.end = Math.max(current.end, inter.end);
            } else { // start > end
                res.add(current);
                current = new Interval(inter.start, inter.end);
            }
        }
        res.add(current);

        return res;
    }
}
