public class S0566ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) {
            return nums;
        }

        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < r*c; i++) {
            res[i/c][i%c] = nums[i/oc][i%oc];
        }
        return res;
    }
}
