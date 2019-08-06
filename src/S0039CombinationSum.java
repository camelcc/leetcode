import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return comb(candidates, target, 0);
    }

    private List<List<Integer>> comb(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 0) {
            return res;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (candidates[i] == target) {
                List<Integer> r = new ArrayList<>();
                r.add(candidates[i]);
                res.add(r);
            } else {
                for (List<Integer> r : comb(candidates, target-candidates[i], i)) {
                    r.add(0, candidates[i]);
                    res.add(r);
                }
            }
        }
        return res;
    }
}
