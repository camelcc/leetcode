import java.util.Arrays;
import java.util.HashMap;

public class S1331RankTransformArray {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] clone = Arrays.copyOf(arr, arr.length);
        Arrays.sort(clone);
        int rank = 1, prev = clone[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prev, rank);
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] == prev) {
                continue;
            }
            rank++;
            prev = clone[i];
            map.put(prev, rank);
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
