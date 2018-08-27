import java.util.ArrayList;
import java.util.List;

public class S0442FindAllDuplicatesArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i+1) {
                continue;
            }

            while (nums[i] != 0 && nums[i] != i+1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    res.add(nums[i]);
                    nums[i] = 0;
                } else {
                    swap(nums, i, nums[i]-1);
                }
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
