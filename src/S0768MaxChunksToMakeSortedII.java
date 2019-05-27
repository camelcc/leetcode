import java.util.Arrays;
import java.util.HashMap;

public class S0768MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int res = 0;

        int k = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        while (k < sorted.length) {
            if (arr[k] != sorted[k]) {
                cnt.put(arr[k], cnt.getOrDefault(arr[k], 0)-1);
                if (cnt.get(arr[k]) == 0) {
                    cnt.remove(arr[k]);
                }
                cnt.put(sorted[k], cnt.getOrDefault(sorted[k], 0)+1);
                if (cnt.get(sorted[k]) == 0) {
                    cnt.remove(sorted[k]);
                }
            }
            if (cnt.isEmpty()) {
                res++;
            }
            k++;
        }
        return res;
    }
}
