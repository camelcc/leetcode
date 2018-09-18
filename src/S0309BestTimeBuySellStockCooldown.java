import java.util.ArrayList;
import java.util.List;

public class S0309BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 0 - start, 1 - buy, 2 - buy cool down, 3 - sell cool down, 4 - sell
        List<Integer> s0 = new ArrayList<>();
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        s0.add(0);
        s1.add(-prices[0]);
        s2.add(Integer.MIN_VALUE);
        for (int i = 1; i < prices.length; i++) {
            s0.add(Math.max(s0.get(i-1), s2.get(i-1)));
            s1.add(Math.max(s1.get(i-1), s0.get(i-1) - prices[i]));
            s2.add(s1.get(i-1) + prices[i]);
        }
        return Math.max(s0.get(prices.length-1), s2.get(prices.length-1));
    }
}
