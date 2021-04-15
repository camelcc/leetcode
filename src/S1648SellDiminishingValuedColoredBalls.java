import java.util.Arrays;

public class S1648SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long res = 0;
        int MOD = 1_000_000_007;

        int i = inventory.length-1;
        int v = inventory[i];
        while (i >= 0 && inventory[i] == v) {
            i--;
        }
        i++; // [i, end) = v

        while (orders > 0) {
            int len = inventory.length-i;
            int gap = i == 0 ? v : v-inventory[i-1];

            if (orders < len * gap) {
                if (orders >= len) {
                    int times = orders/len;
                    long t = (2*v-times+1);
                    t = (t * times / 2) * len;
                    res = (res + t)%MOD;

                    v -= times;
                    orders -= len*times;
                }
                // orders < len
                res = (res + (long)orders * v)%MOD;
                return (int)res;
            }

            // orders >= len * gap
            long t = ((long)(2*v - gap + 1))*gap/2;
            res = (res + t*len)%MOD;
            orders -= len * gap;
            v -= gap;

            i--;
            while (i >= 0 && inventory[i] == v) {
                i--;
            }
            i++; // [i, end) = v
        }
        return (int)res;
    }
}
