public class S0123BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return res;
        }

        res = Math.max(res, maxProfit(prices, 0, prices.length)); // one
        int v = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            v = Math.max(v, prices[i]-min);
            min = Math.min(min, prices[i]);
            res = Math.max(res, v + maxProfit(prices, i+1, prices.length));
        }
        return res;
    }

    private int maxProfit(int[] prices, int start, int end) {
        int res = 0;
        if (start >= prices.length) {
            return res;
        }

        int min = prices[start];
        for (int i = start+1; i < end; i++) {
            res = Math.max(res, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
