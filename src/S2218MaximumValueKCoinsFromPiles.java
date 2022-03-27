import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S2218MaximumValueKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            List<Integer> s = new ArrayList<>();
            List<Integer> pile = piles.get(i);
            int sum = 0;
            for (int j = 0; j < pile.size(); j++) {
                sum += pile.get(j);
                s.add(sum);
            }
            sums.add(s);
        }
        List<HashMap<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            dp.add(new HashMap<>());
        }
        return max(sums, 0, k, dp);
    }

    private int max(List<List<Integer>> sums, int p, int k, List<HashMap<Integer, Integer>> dp) {
        if (p >= sums.size() || k == 0) {
            return 0;
        }
        if (dp.get(p).containsKey(k)) {
            return dp.get(p).get(k);
        }
        int res = max(sums, p+1, k, dp);
        int size = sums.get(p).size();
        for (int i = 0; i < Math.min(size, k); i++) {
            int r = sums.get(p).get(i);
            r += max(sums, p+1, k-(i+1), dp);
            res = Math.max(res, r);
        }
        dp.get(p).put(k, res);
        return res;
    }
}
