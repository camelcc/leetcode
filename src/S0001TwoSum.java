import java.util.HashMap;

public class S0001TwoSum {
    // O(n^2)
    public int[] twoSumBruteForce(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (indices.containsKey(target-v)) {
                return new int[]{indices.get(target-v), i};
            }
            indices.put(v ,i);
        }
        return null;
    }
}


