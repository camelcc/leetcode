public class S1605FindValidMatrixGivenRowColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int result[][] = new int[m][n];

        int cur_row = 0;
        int cur_col = 0;

        while(cur_row < m && cur_col < n){
            result[cur_row][cur_col] = Math.min(rowSum[cur_row],colSum[cur_col]);
            rowSum[cur_row] -= result[cur_row][cur_col];
            colSum[cur_col] -= result[cur_row][cur_col];

            if((rowSum[cur_row] == 0) && (colSum[cur_col] == 0)){
                cur_row++;
                cur_col++;
            }
            else if(rowSum[cur_row] == 0){
                cur_row++;
            }
            else if(colSum[cur_col] == 0){
                cur_col++;
            }

        }

        return result;
    }
}
