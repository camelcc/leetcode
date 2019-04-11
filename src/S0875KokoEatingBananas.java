public class S0875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int high = 0;
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
            high = Math.max(high, pile);
        }
        int low = (int)(sum/H);
        while (low < high) {
            int K = (low+high)/2;
            int newEating = eatingHours(piles, K);
            if (newEating > H) {
                low = K+1;
            } else {
                high = K;
            }
        }
        return high;
    }

    private int eatingHours(int[] piles, int K) {
        double res = 0;
        for (int pile : piles) {
            res += Math.ceil(1.0*pile/K);
        }
        return (int)res;
    }
}
