import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S2164SortEvenOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList();
        List<Integer> odd = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(odd, Comparator.reverseOrder());
        Collections.sort(even);
        int[] res = new int[nums.length];
        int i = 0;
        int ei = 0, oi = 0;
        while (i < nums.length) {
            res[i++] = even.get(ei++);
            if (i < nums.length) {
                res[i++] = odd.get(oi++);
            }
        }
        return res;
    }
}
