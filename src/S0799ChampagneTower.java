import java.util.Arrays;

public class S0799ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pured = new double[query_row+1][query_row+1];
        for (int i = 0; i < query_row+1; i++) {
            Arrays.fill(pured[i], -1);
        }
        pured[0][0] = poured;
        double res = poured(pured, query_row, query_glass);
        return res > 1 ? 1.0 : res;
    }

    private double poured(double[][] poured, int row, int column) {
        if (poured[row][column] >= 0) {
            return poured[row][column];
        }

        double left = 0;
        if (column > 0) {
            left = (poured(poured, row - 1, column - 1) - 1) / 2;
            if (left < 0) {
                left = 0;
            }
        }
        double right = 0;
        if (column != row) {
            right = (poured(poured, row-1, column)-1)/2;
            if (right < 0) {
                right = 0;
            }
        }
        poured[row][column] = left+right;
        return poured[row][column];
    }
}
