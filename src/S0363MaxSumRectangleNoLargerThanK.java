import java.util.TreeSet;

public class S0363MaxSumRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        int M = matrix.length, N = matrix[0].length;

        for (int l = 0; l < N; l++) {
            int[] nums = new int[M];
            for (int r = l; r < N; r++) {
                for (int row = 0; row < M; row++) {
                    nums[row] += matrix[row][r];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int sum = 0;
                for (int b = 0; b < M; b++) {
                    sum += nums[b];
                    Integer v = set.ceiling(sum-k);
                    if (v != null) {
                        res = Math.max(res, sum-v);
                    }
                    set.add(sum);
                }
            }
        }
        return res;
    }
}
