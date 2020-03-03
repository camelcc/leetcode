import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S1365HowManyNumbersAreSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cloned = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cloned);

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int p = Arrays.binarySearch(cloned, v);
            if (p >= 0) {
                while (p >= 0 && cloned[p] == v) {
                    p--;
                }
                p++;
            } else {
                p = -(p+1);
            }
            res[i] = p;
        }
        return res;
    }
}
