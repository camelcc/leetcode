public class S0121BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int lowestBuy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - lowestBuy;
            if (p > profit) {
                profit = p;
            }
            if (lowestBuy > prices[i]) {
                lowestBuy = prices[i];
            }
        }
        return profit;
    }
}
