import java.util.Arrays;
import java.util.HashMap;

public class S0322CoinChange {
    private HashMap<Integer, Integer> change = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        return change(coins, amount);
    }

    private int change(int[] coins, int amount) {
        if (change.containsKey(amount)) {
            return change.get(amount);
        }
        assert amount > 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                continue;
            }
            if (coins[i] == amount) {
                change.put(amount, 1);
                return 1;
            }
            int c = change(coins, amount-coins[i]);
            if (c != -1 && (c+1) < res) {
                res = c+1;
            }
        }
        if (res == Integer.MAX_VALUE) {
            change.put(amount, -1);
            return -1;
        }
        change.put(amount, res);
        return res;
    }
}
