import java.util.*;

public class S1943DescribePainting {
    public List<List<Long>> splitPainting(int[][] segments) {
        long p = 0, color = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] seg : segments) {
            pq.offer(new int[]{seg[0], seg[2]});
            pq.offer(new int[]{seg[1], -seg[2]});
        }
        List<List<Long>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            long pos = t[0];

            if (color != 0) {
                List<Long> r = new ArrayList<>();
                r.add(p);
                r.add(pos);
                r.add(color);
                res.add(r);
            }

            long c = t[1];
            while (!pq.isEmpty() && pq.peek()[0] == pos) {
                c += pq.poll()[1];
            }

            color += c;
            p = pos;
        }
        return res;
    }
}
