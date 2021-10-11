import java.util.TreeMap;

public class S2034StockPriceFluctuation {
    class StockPrice {
        TreeMap<Integer, Integer> prices;
        TreeMap<Integer, Integer> cnt;

        public StockPrice() {
            prices = new TreeMap<>();
            cnt = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if (prices.containsKey(timestamp)) {
                int p = prices.remove(timestamp);
                if (cnt.get(p) <= 1) {
                    cnt.remove(p);
                } else {
                    cnt.put(p, cnt.get(p)-1);
                }
            }
            prices.put(timestamp, price);
            cnt.put(price, cnt.getOrDefault(price, 0)+1);
        }

        public int current() {
            return prices.lastEntry().getValue();
        }

        public int maximum() {
            return cnt.lastKey();
        }

        public int minimum() {
            return cnt.firstKey();
        }
    }
}
