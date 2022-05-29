import java.util.Arrays;
import java.util.Comparator;

public class S2285MaximumTotalImportanceRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int [] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(o -> degree[o]));

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[indices[i]] = i+1;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) weight[i] *degree[i];
        }
        return res;
    }
}
