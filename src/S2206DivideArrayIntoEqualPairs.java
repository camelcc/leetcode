import java.util.HashSet;

public class S2206DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        return set.isEmpty();
    }
}
