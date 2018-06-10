import java.util.ArrayList;
import java.util.List;

public class S0414ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        List<Integer> maxlist = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int j = 0;
            for (int m : maxlist) {
                if (v == m) {
                    j = -1;
                    break;
                }
                if (v > m) {
                    break;
                }
                j++;
                if (j > 3) {
                    break;
                }
            }
            if (j == -1) {
                continue;
            }
            maxlist.add(j, v);
        }
        return maxlist.size() < 3 ? maxlist.get(0) : maxlist.get(2);
    }
}
