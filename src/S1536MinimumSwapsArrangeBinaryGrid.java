import java.util.ArrayList;
import java.util.List;

public class S1536MinimumSwapsArrangeBinaryGrid {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> z = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            int m = 0;
            for (int c = n-1; c >= 0; c--) {
                if (grid[r][c] == 0) {
                    m++;
                } else {
                    break;
                }
            }
            z.add(m);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int valid = n-1-i;
            boolean find = false;
            for (int j = i; j < n; j++) {
                if (z.get(j) >= valid) {
                    res += j-i;
                    int t = z.remove(j);
                    z.add(i, t);
                    find = true;
                    break;
                }
            }
            if (!find) {
                return -1;
            }
        }
        return res;
    }
}
