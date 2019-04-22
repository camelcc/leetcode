import java.util.HashSet;

public class S0898BitwiseORSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        if (A.length <= 1) {
            return A.length;
        }
        HashSet<Integer> last = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> next = new HashSet<>();
            int v = A[i];
            next.add(v);
            for (int or : last) {
                next.add(or | v);
            }
            set.addAll(next);
            last = next;
        }
        return set.size();
    }
}
