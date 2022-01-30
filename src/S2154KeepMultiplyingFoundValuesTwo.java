import java.util.HashSet;

public class S2154KeepMultiplyingFoundValuesTwo {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> val = new HashSet();
        for (int n : nums) {
            val.add(n);
        }
        int res = original;
        while (val.contains(res)) {
            res = res * 2;
        }
        return res;
    }
}
