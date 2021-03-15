import java.util.*;

public class S1591StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {
    /*
    1. For each color, find left top corner and right bottom corner
    2. All colors interfering with given color means they should go after given
    3. Create dependencies (1 -> [2,3])
    4. TopSort. Loops mean it is not possible
    */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> colors = new HashSet<>();
        int rows = targetGrid.length, cols = targetGrid[0].length;

        // just collect all distinct colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) colors.add(targetGrid[i][j]);
        }

        // for each color
        for (var c : colors) {
            int fr = -1, fc = Integer.MAX_VALUE, lr = -1, lc = -1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (targetGrid[i][j] == c) {
                        // update first row if not set
                        if (fr == -1) {
                            fr = i;
                        }
                        // update first column to be as left as possible
                        fc = Math.min(fc, j);
                        // update last row to be as down as possible
                        lr = i;
                        // update last col to be as right as possible
                        lc = Math.max(lc, j);
                    }
                }
            }

            // we now have coordinates for our rectangle. Left top is (fr, fc), right bottom is (lr, lc).
            for (int i = fr; i <= lr; i++) {
                for (int j = fc; j <= lc; j++) {
                    if (targetGrid[i][j] != c) {
                        // there is a color inside our rectangle which is not the color of main rectangle. A dependency is created.
                        graph.computeIfAbsent(c, z->new HashSet<>()).add(targetGrid[i][j]);
                    }
                }
            }
        }

        // just try topsort, return false if not possible, true otherwise
        var visited = new HashSet<Integer>();
        var visiting = new HashSet<Integer>();
        for (var c : colors) {
            if (!topSort(visited,visiting, c, graph)) return false;
        }
        return true;
    }

    boolean topSort(Set<Integer> visited, Set<Integer> visiting, int c, Map<Integer, Set<Integer>> graph) {
        if (visited.contains(c)) return true;
        if (visiting.contains(c)) return false;
        visiting.add(c);

        for (var nei : graph.getOrDefault(c, Collections.emptySet())) {
            if (!topSort(visited,visiting,nei,graph)) return false;
        }

        visiting.remove(c);
        visited.add(c);
        return true;
    }
}
