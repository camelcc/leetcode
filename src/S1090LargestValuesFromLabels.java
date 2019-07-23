import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class S1090LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Integer[] indices = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt((Integer o) -> values[o]).reversed());
        int sum = 0, n = 0, p = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        while (n < num_wanted) {
            while (p < indices.length) {
                int l = labels[indices[p]];
                if (cnt.getOrDefault(l, 0) >= use_limit) {
                    p++;
                } else {
                    break;
                }
            }
            if (p == indices.length) {
                break;
            }
            sum += values[indices[p]];
            cnt.put(labels[indices[p]], cnt.getOrDefault(labels[indices[p]], 0)+1);
            p++;
            n++;
        }
        return sum;
    }
}
