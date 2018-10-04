import java.util.HashMap;

public class S0001TwoSum {
    // O(n^2)
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            int targetValue = target - nums[i];
            // search from [i+1, nums.length)
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == targetValue) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> st = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            if (st.containsKey(target-nums[i])) {
                return new int[] {st.get(remains), i};
            } else {
                st.put(nums[i], i);
            }
        }
        return null;
    }
}


