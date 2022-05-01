import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2257CountUnguardedCellsGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        List<int[]>[] rows = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            rows[i] = new ArrayList();
        }
        List<int[]>[] columns = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            columns[i] = new ArrayList();
        }
        // 0 - guard, 1 - wall
        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];
            rows[r].add(new int[]{c, 0});
            columns[c].add(new int[]{r, 0});
        }
        for (int[] wall : walls) {
            int r = wall[0], c = wall[1];
            rows[r].add(new int[]{c, 1});
            columns[c].add(new int[]{r, 1});
        }
        for (int r = 0; r < m; r++) {
            Collections.sort(rows[r], (o1, o2) -> o1[0]-o2[0]);
        }
        for (int c = 0; c < n; c++) {
            Collections.sort(columns[c], (o1, o2) -> o1[0]-o2[0]);
        }

        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int rp = Collections.binarySearch(rows[r], new int[]{c, 0}, (o1, o2) -> o1[0]-o2[0]);
                if (rp >= 0) {
                    continue;
                }
                rp = -(rp+1);
                if (rp > 0 && rows[r].get(rp-1)[1] == 0) {
                    continue;
                }
                if (rp < rows[r].size() && rows[r].get(rp)[1] == 0) {
                    continue;
                }
                int cp = Collections.binarySearch(columns[c], new int[]{r, 0}, (o1, o2) -> o1[0]-o2[0]);
                if (cp >= 0) {
                    continue;
                }
                cp = -(cp+1);
                if (cp > 0 && columns[c].get(cp-1)[1] == 0) {
                    continue;
                }
                if (cp < columns[c].size() && columns[c].get(cp)[1] == 0) {
                    continue;
                }
                res++;
            }
        }
        return res;
    }
}
