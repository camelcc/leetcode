import java.util.Arrays;

// TODO:  DP solution
public class S0518CoinChange2 {
    public int change(int amount, int[] coins) {
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return 0;
        }
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? 1 : 0;
        }

        int count = 0;
        // must use coins[0]
        count += change(amount - coins[0], coins);

        int[] remains = Arrays.copyOfRange(coins, 1, coins.length);
        count += change(amount, remains);

        return count;
    }
}
