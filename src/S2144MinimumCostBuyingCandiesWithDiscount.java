import java.util.Arrays;

public class S2144MinimumCostBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        int res = 0;
        Arrays.sort(cost);
        int i = cost.length-1;

        while (i >= 0) {
            res += cost[i];
            if (i == 0) {
                return res;
            }
            i--;
            res += cost[i];
            if (i == 0) {
                return res;
            }
            i--;
            i--;
        }
        return res;
    }
}
