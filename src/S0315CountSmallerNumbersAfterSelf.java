import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0315CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
        }

        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            int v = nums[i];
            int p = Collections.binarySearch(sorted, v);
            if (p < 0) {
                p = -(p+1);
            } else {
                while (p > 0 && sorted.get(p).intValue() == sorted.get(p-1).intValue()) {
                    p--;
                }
            }
            res.set(i, p);
            sorted.add(p, v);
        }
        return res;
    }
}
