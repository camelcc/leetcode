import java.util.*;

public class S1851MinimumIntervalIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            int len = interval[1] - interval[0] + 1;
            pq.offer(new int[]{interval[0], len});
            pq.offer(new int[]{interval[1]+1, -len});
        }
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(o -> queries[o]));
        int[] res = new int[queries.length];
        for (int i = 0; i < index.length; i++) {
            int loc = queries[index[i]];
            while (!pq.isEmpty() && pq.peek()[0] <= loc) {
                int[] t = pq.poll();
                if (t[1] > 0) {
                    cnt.put(t[1], cnt.getOrDefault(t[1], 0)+1);
                } else {
                    if (cnt.get(-t[1]) == 1) {
                        cnt.remove(-t[1]);
                    } else {
                        cnt.put(-t[1], cnt.get(-t[1])-1);
                    }
                }
            }
            res[index[i]] = cnt.isEmpty() ? -1 : cnt.firstKey();
        }
        return res;
    }
}
