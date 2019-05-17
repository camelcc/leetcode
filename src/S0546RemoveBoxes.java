public class S0546RemoveBoxes {

    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) {
            return 0;
        }

        int[][][] dp = new int[boxes.length][boxes.length][boxes.length+1];
        return remove(boxes, 0, boxes.length-1, 1, dp);
    }

    private int remove(int[] boxes, int lo, int hi, int k, int[][][] dp) {
        if (dp[lo][hi][k] > 0) {
            return dp[lo][hi][k];
        }
        int res = 0;
        if (lo > hi) {
            return 0;
        } else if (lo == hi) {
            res = k*k;
        } else {
            res = k*k+remove(boxes, lo+1, hi, 1, dp);
            for (int m = lo+1; m <= hi; m++) {
                if (boxes[m] == boxes[lo]) {
                    int t = remove(boxes, lo+1, m-1, 1, dp) + remove(boxes, m, hi, k+1, dp);
                    res = Math.max(res, t);
                }
            }
        }
        dp[lo][hi][k] = res;
        return res;
    }
}
