import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class S1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : arr1) {
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
        }
        int[] res = new int[arr1.length];
        int p = 0;
        for (int v : arr2) {
            for (int t = 0; t < cnt.get(v); t++) {
                res[p++] = v;
            }
            cnt.remove(v);
        }
        List<Integer> remains = new ArrayList<>(cnt.keySet());
        Collections.sort(remains);
        for (int k : remains) {
            for (int t = 0; t < cnt.get(k); t++) {
                res[p++] = k;
            }
        }
        return res;
    }
}
