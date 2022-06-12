import java.util.Arrays;

public class S2300SuccessfulPairsSpellsPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long s = (long) Math.ceil(success/spells[i]);
            if (s > potions[potions.length-1]) {
                continue;
            }
            int lo = 0, hi = potions.length;
            while (lo < hi) {
                int mid = lo + (hi-lo)/2;
                if (1L*spells[i]*potions[mid] >= success) {
                    if (lo == mid) {
                        break;
                    }
                    hi = mid;
                } else {
                    lo = mid+1;
                }
            }
            res[i] = potions.length-lo;
        }
        return res;
    }
}
