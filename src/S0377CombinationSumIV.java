import java.util.Arrays;
import java.util.HashMap;

//TODO: DP solution
public class S0377CombinationSumIV {
    private HashMap<Integer, Integer> counted = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        assert target > 0;
        Arrays.sort(nums);

        int count = 0;
        if (nums.length == 0) {
            return count;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                count++;
            }
            return count;
        }

        count += count(nums, target);
        return count;
    }

    private int count(int[] nums, int target) {
        if (counted.containsKey(target)) {
            return counted.get(target);
        }
        // nums.length > 1, target > 0

        int count = 0;
        // nums.length >= 2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (nums[i] == target) {
                count++;
                break;
            }
            // pick i, target > nums[i]
            count += count(nums, target - nums[i]);
        }
        counted.put(target, count);
        return count;
    }
}
