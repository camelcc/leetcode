public class S0495TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0;
        int end = 0;
        int total = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            int t = timeSeries[i];
            if (t <= end) {
                end = t + duration;
            } else {
                total += end - start;

                start = t;
                end = t + duration;
            }
        }
        total += end - start;

        return total;
    }
}
