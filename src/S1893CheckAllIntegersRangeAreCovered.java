public class S1893CheckAllIntegersRangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[right-left+1];
        for (int[] range : ranges) {
            if (range[0] > right || range[1] < left) {
                continue;
            }
            for (int v = Math.max(left, range[0]); v <= Math.min(right, range[1]); v++) {
                covered[v-left] = true;
            }
        }
        for (boolean c : covered) {
            if (!c) {
                return false;
            }
        }
        return true;
    }
}
