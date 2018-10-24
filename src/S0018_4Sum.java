import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int sum = target - nums[i] - nums[j];
                int lo = j+1, hi = nums.length-1;
                while (lo < hi) {
                    int s = nums[lo] + nums[hi];
                    if (s == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
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
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
