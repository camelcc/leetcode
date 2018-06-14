import java.util.ArrayList;
import java.util.List;

public class S0448NumbersDisappeared {
    //TODO: mark position val to negative
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] == i) {
                continue;
            }

            int t = nums[i-1];
            nums[i-1] = 0;
            while (!(nums[t-1] == t || nums[t-1] == 0)) {
                int j = nums[t-1];
                nums[t-1] = t;
                t = j;
            }
            nums[t-1] = t;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
