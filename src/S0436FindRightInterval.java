import java.util.Arrays;
import java.util.Comparator;

public class S0436FindRightInterval {
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

    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        if (intervals.length <= 1) {
            return res;
        }

        Integer[] index = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return intervals[o1].start - intervals[o2].start;
            }
        });
        for (int i = 0; i < index.length; i++) {
            int j = i+1;
            int end = intervals[index[i]].end;
            while (j < index.length && intervals[index[j]].start < end) {
                j++;
            }
            if (j < index.length) {
                res[index[i]] = index[j];
            }
        }
        return res;
    }
}
