import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S2070MostBeautifulItemEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < queries.length; i++) {
            pq.offer(new int[]{queries[i], i});
        }
        int[] res = new int[queries.length];
        int i = 0, max = 0;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int p = t[0], index = t[1];
            while (i < items.length && items[i][0] <= p) {
                max = Math.max(max, items[i][1]);
                i++;
            }
            res[index] = max;
        }
        return res;
    }
}
