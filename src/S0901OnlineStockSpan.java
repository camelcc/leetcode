import java.util.Stack;

public class S0901OnlineStockSpan {
    class StockSpanner {
        private Stack<int[]> prices;

        public StockSpanner() {
            prices = new Stack<>();
        }

        public int next(int price) {
            if (prices.isEmpty()) {
                prices.push(new int[]{price, 1});
                return 1;
            }

            int cnt = 1;
            while (!prices.isEmpty() && prices.peek()[0] <= price) {
                cnt += prices.pop()[1];
            }
            prices.push(new int[]{price, cnt});
            return cnt;
        }
    }
}
