public class S0376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] peek = new int[nums.length];
        int[] low = new int[nums.length];
        peek[0] = 1;
        low[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (v > nums[i-1]) {
                peek[i] = low[i-1]+1;
                low[i] = low[i-1];
            } else if (v < nums[i-1]) {
                low[i] = peek[i-1]+1;
                peek[i] = peek[i-1];
            } else {
                peek[i] = peek[i-1];
                low[i] = low[i-1];
            }
        }
        return Math.max(peek[nums.length-1], low[nums.length-1]);
    }
}
