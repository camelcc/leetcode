import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return sum(candidates, 0, target);
    }

    private List<List<Integer>> sum(int[] candidates, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates[start] > target) {
            return res;
        }
        int next = start;
        while (next < candidates.length && candidates[next] == candidates[start]) {
            next++;
        }
        if (next < candidates.length) {
            res.addAll(sum(candidates, next, target));
        }

        List<Integer> current = new ArrayList<>();
        int sum = 0;
        int c = start;
        while (c < next) {
            sum += candidates[c];
            current.add(candidates[c]);
            if (sum == target) {
                res.add(new ArrayList<>(current));
            }
            // consume
            if (next < candidates.length) {
                for (List<Integer> r : sum(candidates, next, target-sum)) {
                    List<Integer> t = new ArrayList<>(current);
                    t.addAll(r);
                    res.add(t);
                }
            }
            c++;
        }
        return res;
    }
}
