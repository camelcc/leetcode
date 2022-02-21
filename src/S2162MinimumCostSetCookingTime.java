import java.util.ArrayList;
import java.util.List;

public class S2162MinimumCostSetCookingTime {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int res = Integer.MAX_VALUE;
        // targetSeconds >= 60
        int mins = Math.max(0, (targetSeconds-99)/60);
        while (60*mins <= targetSeconds && mins < 100) {
            int seconds = targetSeconds-60*mins;
            if (seconds >= 100) {
                mins++;
                continue;
            }
            List<Integer> digits = new ArrayList<>();
            if (mins > 0) {
                if (mins < 10) {
                    digits.add(mins);
                } else {
                    digits.add(mins/10);
                    digits.add(mins%10);
                }
            }
            if (mins > 0 || seconds >= 10) {
                digits.add(seconds/10);
                digits.add(seconds%10);
            } else {
                digits.add(seconds);
            }
            mins++;
            int r = cost(startAt, moveCost, pushCost, digits);
            res = Math.min(res, r);
        }
        return res;
    }

    private int cost(int start, int moveCost, int pushCost, List<Integer> digits) {
        int current = start, res = 0;
        for (int digit : digits) {
            if (current != digit) {
                res += moveCost;
            }
            current = digit;
            res += pushCost;
        }
        return res;
    }
}
