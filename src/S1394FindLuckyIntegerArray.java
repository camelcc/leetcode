import java.util.HashMap;
import java.util.HashSet;

public class S1394FindLuckyIntegerArray {
    public int findLucky(int[] arr) {
        HashSet<Integer> lucky = new HashSet<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int a : arr)  {
            cnt.put(a, cnt.getOrDefault(a, 0)+1);
            if (a == cnt.get(a)) {
                lucky.add(a);
            } else {
                lucky.remove(a);
            }
        }
        int res = -1;
        for (int v : lucky) {
            res = Math.max(res, v);
        }
        return res;
    }
}
