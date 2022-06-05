import java.util.HashMap;
import java.util.HashSet;

public class S2295ReplaceElementsArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> n2i = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            n2i.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            int from = operations[i][0], to = operations[i][1];
            nums[n2i.get(from)] = to;
            n2i.put(to, n2i.remove(from));
        }

        return nums;
    }
}
