import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S1054DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int most = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 0);
        for (int bar : barcodes) {
            cnt.put(bar, cnt.getOrDefault(bar, 0)+1);
            if (cnt.get(bar) > cnt.get(most)) {
                most = bar;
            }
        }
        ArrayList<Integer>[] groups = new ArrayList[cnt.get(most)];
        for (int i = 0; i < cnt.get(most); i++) {
            groups[i] = new ArrayList<>();
            groups[i].add(most);
        }
        cnt.remove(most);
        int p = 0, N = groups.length;
        for (int code : cnt.keySet()) {
            for (int i = 0; i < cnt.get(code); i++) {
                groups[p].add(code);
                p = (p+1)%N;
            }
        }
        int[] res = new int[barcodes.length];
        p = 0;
        for (List<Integer> group : groups) {
            for (int v : group) {
                res[p++] = v;
            }
        }
        return res;
    }
}
