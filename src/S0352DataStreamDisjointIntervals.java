import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class S0352DataStreamDisjointIntervals {
    public static class SummaryRanges {
        HashMap<Integer, Integer> intervals;
        List<Integer> starts;

        public SummaryRanges() {
            intervals = new HashMap<>();
            starts = new ArrayList<>();
        }

        public void addNum(int val) {
            if (starts.isEmpty()) {
                starts.add(val);
                intervals.put(val, val);
                return;
            }

            int p = Collections.binarySearch(starts, val);
            if (p >= 0) {
                return;
            }
            // start.size >= 1
            p = -(p+1);
            if (p > 0) {
                int pre = intervals.get(starts.get(p-1));
                if (pre >= val) {
                    return;
                } else if (pre+1 == val) {
                    intervals.put(starts.get(p-1), val);
                    if (p < starts.size()) {
                        if (starts.get(p) == val+1) {
                            intervals.put(starts.get(p-1), intervals.get(starts.get(p)));
                            intervals.remove(starts.get(p));
                            starts.remove(p);
                        }
                    }
                    return;
                }
            }

            if (p < starts.size()) {
                if (starts.get(p) == val+1) {
                    starts.set(p, val);
                    int end = intervals.get(val+1);
                    intervals.remove(val+1);
                    intervals.put(val, end);
                    return;
                }
            }

            starts.add(p, val);
            intervals.put(val, val);
        }

        public int[][] getIntervals() {
            int[][] res = new int[starts.size()][2];
            for (int i = 0; i < starts.size(); i++) {
                res[i][0] = starts.get(i);
                res[i][1] = intervals.get(starts.get(i));
            }
            return res;
        }
    }
}
