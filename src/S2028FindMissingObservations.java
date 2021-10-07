public class S2028FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        long total = 0;
        for (int r : rolls) {
            total += r;
        }
        long remains = (long)(rolls.length+n)*mean - total;
        if (remains < n || remains > 6L*n) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (int) Math.min(remains-(n-(i+1)), 6);
            remains -= res[i];
        }
        return res;
    }
}
