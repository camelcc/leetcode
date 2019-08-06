import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return comb(candidates, target, 0);
    }

    private List<List<Integer>> comb(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList();
        if (target <= 0) {
            return res;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (candidates[i] == target) {
                List<Integer> r = new ArrayList();
                r.add(target);
                res.add(r);
                return res;
            }
            for (List<Integer> r : comb(candidates, target-candidates[i], i+1)) {
                r.add(0, candidates[i]);
                res.add(r);
            }
            while (i < candidates.length-1 && candidates[i] == candidates[i+1]) {
                i++;
            }
        }
        return res;
    }
}
