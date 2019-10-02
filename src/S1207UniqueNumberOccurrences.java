import java.util.HashMap;
import java.util.HashSet;

public class S1207UniqueNumberOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> vals = new HashSet<>();
        for (int a : arr) {
            freq.put(a, freq.getOrDefault(a, 0)+1);
            vals.add(a);
        }
        HashSet<Integer> occ = new HashSet<>();
        for (int v : vals) {
            if (occ.contains(freq.get(v))) {
                return false;
            }
            occ.add(freq.get(v));
        }
        return true;
    }
}
