import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combination(candidates, target);
    }

    private List<List<Integer>> combination(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        if (candidates[0] > target) {
            return res;
        }

        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            int picked = candidates[i];
            if (picked == target) {
                List<Integer> t = new ArrayList<>();
                t.add(picked);
                res.add(t);
            } else { // <
                int[] remainingCards = new int[candidates.length-i];
                for (int j = i; j < candidates.length; j++) {
                    remainingCards[j-i] = candidates[j];
                }

                List<List<Integer>> rest = combinationSum(remainingCards, target-picked);
                for (List<Integer> r : rest) {
                    r.add(picked);
                    res.add(r);
                }
            }
        }
        return res;
    }
}
