import java.util.TreeMap;

public class S1801NumberOrdersBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer, Integer> sell = new TreeMap<>();
        TreeMap<Integer, Integer> buy = new TreeMap<>();
        for (int[] order : orders) {
            int price = order[0], amount = order[1];
            if (order[2] == 0) { // buy
                while (!sell.isEmpty() && sell.firstKey() <= price && amount > 0) {
                    int key = sell.firstKey();
                    int cnt = sell.get(key);
                    if (amount >= cnt) {
                        amount -= cnt;
                        sell.remove(key);
                    } else {
                        sell.put(key, cnt-amount);
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    buy.put(price, buy.getOrDefault(price, 0)+amount);
                }
            } else if (order[2] == 1) { // sell
                while (!buy.isEmpty() && buy.lastKey() >= price && amount > 0) {
                    int key = buy.lastKey();
                    int cnt = buy.get(key);
                    if (amount >= cnt) {
                        amount -= cnt;
                        buy.remove(key);
                    } else {
                        buy.put(key, cnt-amount);
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    sell.put(price, sell.getOrDefault(price, 0)+amount);
                }
            }
        }
        long res = 0;
        for (int v : sell.values()) {
            res += v;
        }
        for (int v : buy.values()) {
            res += v;
        }
        int MOD = 1_000_000_007;
        return (int)(res%MOD);
    }
}
