import java.util.Arrays;

public class S1561MaximumNumberCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int r = piles.length-1, l = 0;
        while (l < r) {
            res += piles[r-1];
            r -= 2;
            l++;
        }
        return res;
    }
}
