import java.util.HashMap;
import java.util.LinkedList;

public class S1553MinimumNumberDaysEatNOranges {
    public int minDays(int n) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        return days(n, dp);
    }

    private int days(int n, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int res = n;
        // option 1
        int remains = n%2 + days(n/2, dp);
        remains = Math.min(remains, n%3 + days(n/3, dp));
        res = Math.min(res, 1 + remains);
        dp.put(n, res);
        return res;
    }
}
