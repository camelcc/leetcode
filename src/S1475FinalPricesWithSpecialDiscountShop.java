import java.util.Arrays;
import java.util.LinkedList;

public class S1475FinalPricesWithSpecialDiscountShop {
    public int[] finalPrices(int[] prices) {
        int[] res = Arrays.copyOf(prices, prices.length);
        LinkedList<int[]> current = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            LinkedList<int[]> next = new LinkedList<>();
            next.offer(new int[]{prices[i], i});
            for (int[] c : current) {
                if (c[0] >= prices[i]) {
                    res[c[1]] = c[0]-prices[i];
                } else {
                    next.offer(c);
                }
            }
            current = next;
        }
        return res;
    }
}
