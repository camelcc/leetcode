import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            }
            if (i == candidates.length-1) {
                return res;
            }

            int dup = i+1;
            while (dup < candidates.length && candidates[dup] == candidates[i]) {
                dup++;
            }

            if (dup > i+1) {
                List<Integer> d = new ArrayList<>();
                d.add(picked);
                int t = target-picked;
                int m = i+1;
                while (m < dup && t > 0) {
                    t -= candidates[m];
                    d.add(candidates[m++]);
                }
                if (t == 0 && m > i+1) {
                    res.add(d);
                }
                if (dup == candidates.length) {
                    return res;
                }
            }

            int[] remainingCards = new int[candidates.length-dup];
            for (int k = dup; k < candidates.length; k++) {
                remainingCards[k-dup] = candidates[k];
            }

            List<Integer> selected = new ArrayList<>();
            int remainingTarget = target;
            for (int t = i; t < dup; t++) {
                remainingTarget = remainingTarget - candidates[t];
                selected.add(candidates[t]);

                List<List<Integer>> rest = combination(remainingCards, remainingTarget);
                for (List<Integer> r : rest) {
                    r.addAll(selected);
                    res.add(r);
                }
            }
            i = dup-1;
        }
        return res;
    }
}
