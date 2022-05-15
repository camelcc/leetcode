public class S2275LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {
        int res = 0;
        int bit = 0;
        while (bit < 31) {
            int b = 0x1<<bit;
            int zeros = 0;
            for (int c : candidates) {
                if ((c&b) == 0) {
                    zeros++;
                }
            }
            res = Math.max(res, candidates.length-zeros);
            bit++;
        }
        return res;
    }
}
