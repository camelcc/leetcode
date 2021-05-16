import java.util.HashMap;
import java.util.TreeSet;

public class S1713MinimumOperationsMakeSubsequence {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            index.put(target[i], i);
        }
        TreeSet<Integer> lcs = new TreeSet<>();
        for (int a : arr) {
            if (!index.containsKey(a)) {
                continue;
            }
            int i = index.get(a);
            if (lcs.isEmpty() || lcs.last() < i) {
                lcs.add(i);
            } else {
                int ni = lcs.ceiling(i);
                lcs.remove(ni);
                lcs.add(i);
            }
        }
        return target.length - lcs.size();
    }
}
