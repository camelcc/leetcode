public class S1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, saved = 0, gsum = 0, swindow = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i];
            gsum += grumpy[i] * customers[i];
            swindow += grumpy[i] * customers[i];
            if (i >= X) {
                swindow -= grumpy[i-X]*customers[i-X];
            }
            saved = Math.max(saved, swindow);
        }
        return sum - gsum + saved;
    }
}
