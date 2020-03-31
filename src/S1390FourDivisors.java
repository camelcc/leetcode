import java.util.HashMap;
import java.util.HashSet;

public class S1390FourDivisors {
    public int sumFourDivisors(int[] nums) {
        HashMap<Integer, HashSet<Integer>> dividers = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            HashSet<Integer> d = dividers(n, dividers);
            if (d.size() != 4) {
                continue;
            }
            for (int v : d) {
                res += v;
            }
        }
        return res;
    }

    private HashSet<Integer> dividers(int num, HashMap<Integer, HashSet<Integer>> dp) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        HashSet<Integer> res = new HashSet<>();
        res.add(1);
        res.add(num);
        for (int d = 2; d <= Math.ceil(Math.sqrt(num)); d++) {
            if (num%d == 0) {
                res.add(d);
                res.addAll(dividers(num/d, dp));
            }
        }
        dp.put(num, res);
        return res;
    }
}
