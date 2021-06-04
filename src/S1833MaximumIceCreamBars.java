import java.util.Arrays;

public class S1833MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0, p = 0;
        while (p < costs.length && coins >= costs[p]) {
            res++;
            coins -= costs[p];
            p++;
        }
        return res;
    }
}
