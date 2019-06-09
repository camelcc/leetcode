import java.util.ArrayList;
import java.util.List;

public class S0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), nums, 0);
        return permutations;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> per, int[] nums, int start) {
        if (per.size() == nums.length) {
            res.add(new ArrayList<>(per));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (per.contains(nums[i])) {
                continue;
            }
            per.add(nums[i]);
            backtrack(res, per, nums, start+1);
            per.remove((Integer)nums[i]);
        }
    }
}
