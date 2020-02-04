import java.util.*;

public class S1338ReduceArraySizeTheHalf {
    public int minSetSize(int[] arr) {
        int remains = arr.length/2;
        int res = 0;

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int a : arr) {
            cnt.put(a, cnt.getOrDefault(a, 0)+1);
        }
        List<Integer> keys = new ArrayList<>(cnt.keySet());
        keys.sort(Comparator.comparingInt(cnt::get).reversed());
        while (remains > 0) {
            int c = cnt.get(keys.get(res));
            remains -= c;
            res++;
        }
        return res;
    }
}
