public class S0309BestTimeBuySellStockCooldown {
    //TODO: DP solution
    public int maxProfit(int[] prices) {
        // 0 - start, 1 - buy, 2 - buy cool down, 3 - sell cool down, 4 - sell
        return market(prices, 0, 0, 0);
    }

    private int market(int[] prices, int day, int previsouAction, int profit) {
        if (day == prices.length) {
            return profit;
        }

        int res = Integer.MIN_VALUE;
        if (previsouAction == 0) { // start
            // start
            int start = market(prices, day+1, 0, profit);
            if (res < start) {
                res = start;
            }

            // buy
            int buy = market(prices, day+1, 1, profit - prices[day]);
            if (res < buy) {
                res = buy;
            }
        } else if (previsouAction == 1 || previsouAction == 2) { // buy, buy cool down
            // sell
            int sell = market(prices, day+1, 4, profit + prices[day]);
            if (res < sell) {
                res = sell;
            }

            // buy cool down
            int cool = market(prices, day+1, 2, profit);
            if (res < cool) {
                res = cool;
            }
        } else if (previsouAction == 3) { // sell cool down
            // buy
            int buy = market(prices, day+1, 1, profit - prices[day]);
            if (res < buy) {
                res = buy;
            }

            // sell cool down
            int cool = market(prices, day+1, 3, profit);
            if (res < cool) {
                res = cool;
            }
        } else if (previsouAction == 4) { // sell
            // must sell cool down
            int cool = market(prices, day+1, 3, profit);
            if (res < cool) {
                res = cool;
            }
        }

        return res;
    }
}
