public class S1981MinimizeDifferenceBetweenTargetChosenElements {
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][5000];
        return min(mat, 0, 0, target, dp);
    }

    private int min(int[][] mat, int row, int sum, int target, Integer[][] dp) {
        if (dp[row][sum] != null) {
            return dp[row][sum];
        }
        if (sum >= target) {
            int min = mat[row][0];
            for (int c = 0; c < mat[0].length; c++) {
                min = Math.min(min, mat[row][c]);
            }
            if (row == mat.length-1) {
                dp[row][sum] = sum+min-target;
            } else {
                dp[row][sum] = min(mat, row+1, sum+min, target, dp);
            }
            return dp[row][sum];
        }

        int res = Integer.MAX_VALUE;
        // sum < target
        if (row == mat.length-1) {
            for (int c = 0; c < mat[row].length; c++) {
                res = Math.min(res, Math.abs(sum+mat[row][c]-target));
            }
            dp[row][sum] = res;
            return dp[row][sum];
        }

        // sum < target
        for (int c = 0; c < mat[0].length; c++) {
            res = Math.min(res, min(mat, row+1, sum+mat[row][c], target, dp));
        }
        dp[row][sum] = res;
        return dp[row][sum];
    }
}
