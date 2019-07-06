import java.util.ArrayList;
import java.util.List;

public class S0957PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        List<Integer> map = new ArrayList<>();
        int start = cell(cells);
        int[] current = cells;
        while (N > 0 && !map.contains(start)) {
            map.add(start);
            current = next(current);
            start = cell(current);
            N--;
        }
        if (N == 0) {
            return current;
        }

        int begin = map.indexOf(start);
        assert begin >= 0;
        int period = map.size()-begin;
        N = N%period;
        int res = map.get(begin+N);
        return cell(res);
    }

    private int[] next(int[] cell) {
        int[] res = new int[cell.length];
        for (int i = 1; i < cell.length-1; i++) {
            res[i] = ((cell[i-1] == 1 && cell[i+1] == 1) ||
                    (cell[i-1] == 0 && cell[i+1] == 0)) ? 1 : 0;
        }
        return res;
    }

    private int[] cell(int cell) {
        int[] res = new int[8];
        for (int i = 0; i < 8; i++) {
            res[7-i] = cell%2;
            cell = cell >> 1;
        }
        return res;
    }

    private int cell(int[] cells) {
        int res = 0;
        for (int i = 0; i < cells.length; i++) {
            res = (res << 1) + cells[i];
        }
        return res;
    }
}
