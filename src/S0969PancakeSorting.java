import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S0969PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt((Integer o) -> A[o]).reversed());
        int[] sorted = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sorted[i] = indices[i];
        }

        List<Integer> res = new ArrayList<>();
        int len = 0;
        while (len < A.length) {
            int max = sorted[len];
            if (max == A.length-1-len) {
                len++;
                continue;
            }

            if (max != 0) {
                res.add(max+1);
            }
            res.add(A.length-len);
            int[] next = new int[A.length];
            for (int i = len+1; i < A.length; i++) {
                if (sorted[i] > max) {
                    next[i] = A.length-1-len-sorted[i];
                } else if (sorted[i] < max) {
                    next[i] = sorted[i] + A.length - 1 - len - max;
                }
            }
            sorted = next;
            len++;
        }
        return res;
    }
}
