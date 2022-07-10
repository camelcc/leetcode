import java.util.Arrays;

public class S2335MinimumAmountTimeFillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = 0;
        while (amount[0] > 0) {
            amount[0]--;
            res++;
            if (amount[1] == amount[2]) {
                amount[1]--;
            } else {
                amount[2]--;
            }
        }
        res += Math.max(amount[1], amount[2]);
        return res;
    }
}
