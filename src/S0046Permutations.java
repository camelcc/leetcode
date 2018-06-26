import java.util.ArrayList;
import java.util.List;

public class S0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }
        if (nums.length == 1) {
            List<Integer> a = new ArrayList<>();
            a.add(nums[0]);
            permutations.add(a);
            return permutations;
        }

        for (int i = 0; i < nums.length; i++) {
            int picked = nums[i];

            int[] remains = new int[nums.length-1];
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                remains[k++] = nums[j];
            }

            List<List<Integer>> perm = permute(remains);
            for (List<Integer> p : perm) {
                p.add(picked);
                permutations.add(p);
            }
        }
        return permutations;
    }
}
