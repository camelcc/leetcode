import java.util.ArrayList;
import java.util.List;

public class S1253Reconstruct2RowBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> u = new ArrayList<>();
        List<Integer> l = new ArrayList<>();


        int[][] array = new int[2][colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] != 2) {
                continue;
            }
            array[0][i] = 1;
            array[1][i] = 1;
            upper--;
            lower--;
        }
        if (upper < 0 || lower < 0) {
            return res;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] != 1) {
                continue;
            }
            if (upper <= 0 && lower <= 0) {
                return res;
            } else if (upper <= 0) {
                array[1][i] = 1;
                lower--;
            } else {
                array[0][i] = 1;
                upper--;
            }
        }
        if (upper != 0 || lower != 0) {
            return res;
        }

        for (int ud : array[0]) {
            u.add(ud);
        }
        for (int ld : array[1]) {
            l.add(ld);
        }
        res.add(u);
        res.add(l);
        return res;
    }
}

