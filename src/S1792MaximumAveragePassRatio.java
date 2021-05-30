import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToDoubleFunction;

public class S1792MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble((ToDoubleFunction<int[]>) o -> (o[1]-o[0])*1.0/(o[1]*(o[1]+1.0))).reversed());
        for (int[] clz: classes) {
            pq.offer(clz);
        }
        while (extraStudents > 0) {
            int[] t = pq.poll();
            pq.offer(new int[]{t[0]+1, t[1]+1});
            extraStudents--;
        }
        double res = 0;
        for (int[] clz : pq) {
            res += clz[0]*1.0/clz[1];
        }
        return res/classes.length;
    }
}
