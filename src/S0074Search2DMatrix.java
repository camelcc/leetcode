public class S0074Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        int lo = 0, hi = M*N-1;
        while (lo <= hi) {
            if (lo == hi) {
                return matrix[lo/N][lo%N] == target;
            }

            int mid = (lo+hi)/2;
            int val = matrix[mid/N][mid%N];
            if (val == target) {
                return true;
            } else if (val < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return false;
    }
}
