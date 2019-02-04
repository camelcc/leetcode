public class S0714BestTimeBuySellStockTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = 0 - prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]-fee);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }
}
