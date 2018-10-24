import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int lo = i+1, hi = nums.length-1, sum = 0-nums[i];
            while (lo < hi) {
                if (lo > i+1 && nums[lo] == nums[lo-1]) {
                    lo++;
                    continue;
                }
                if (hi < nums.length-1 && nums[hi] == nums[hi+1]) {
                    hi--;
                    continue;
                }

                int s = nums[lo]+nums[hi];
                if (s == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < nums.length && nums[lo] == nums[lo-1]) {
                        lo++;
                    }
                    while (hi >= 0 && nums[hi] == nums[hi+1]) {
                        hi--;
                    }
                } else if (s < sum) {
                    lo++;
                } else { // s > sum
                    hi--;
                }
            }
        }

        return res;
    }
}
