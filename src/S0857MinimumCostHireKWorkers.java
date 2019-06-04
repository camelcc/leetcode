import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S0857MinimumCostHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Integer[] indices = new Integer[wage.length];
        for (int i = 0; i < wage.length; i++) {
            indices[i] = i;
        }
        // sort by wage per quality
        Arrays.sort(indices, Comparator.comparingDouble((Integer i) -> wage[i]*1.0/quality[i]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double res = Double.MAX_VALUE;

        int qualitySum = 0;
        for (int i = 0; i < indices.length; i++) {
            qualitySum += quality[indices[i]];
            pq.add(quality[indices[i]]);
            if (pq.size() > K) {
                qualitySum -= pq.poll(); // remove worker with biggest quality
            }
            if (pq.size() == K) {
                res = Math.min(res, qualitySum*(wage[indices[i]]*1.0/quality[indices[i]]));
            }
        }
        return res;
    }
}
