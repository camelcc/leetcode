import java.util.Arrays;
import java.util.HashMap;

public class S0518CoinChange2 {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public int change(int amount, int[] coins) {
        map = new HashMap<>();
        Arrays.sort(coins);
        return change(amount, coins, 0);
    }

    private int change(int amount, int[] coins, int minCoinIndex) {
        if (map.containsKey(minCoinIndex) && map.get(minCoinIndex).containsKey(amount)) {
            return map.get(minCoinIndex).get(amount);
        }
        if (amount == 0) {
            if (!map.containsKey(minCoinIndex)) {
                map.put(minCoinIndex, new HashMap<>());
            }
            map.get(minCoinIndex).put(amount, 1);
            return 1;
        }
        if (amount < 0 || minCoinIndex >= coins.length || amount < coins[minCoinIndex]) {
            if (!map.containsKey(minCoinIndex)) {
                map.put(minCoinIndex, new HashMap<>());
            }
            map.get(minCoinIndex).put(amount, 0);
            return 0;
        }


        if (coins.length == 1) {
            int count = amount % coins[0] == 0 ? 1 : 0;
            if (!map.containsKey(minCoinIndex)) {
                map.put(minCoinIndex, new HashMap<>());
            }
            map.get(minCoinIndex).put(amount, count);
            return count;
        }

        int count = 0;
        count += change(amount - coins[minCoinIndex], coins, minCoinIndex);
        if (minCoinIndex < coins.length - 1) {
            count += change(amount, coins, minCoinIndex+1);
        }
        if (!map.containsKey(minCoinIndex)) {
            map.put(minCoinIndex, new HashMap<>());
        }
        map.get(minCoinIndex).put(amount, count);
        return count;
    }
}
