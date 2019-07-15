import java.util.HashMap;
import java.util.HashSet;

public class S1001GridIllumination {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> horizon = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> verticle = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> diagonalxl = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> diagonalxr = new HashMap<>();
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1], p = r*N+c;
            horizon.putIfAbsent(lamp[0], new HashSet<>());
            horizon.get(lamp[0]).add(p);
            verticle.putIfAbsent(lamp[1], new HashSet<>());
            verticle.get(lamp[1]).add(p);
            int xl = c-r;
            diagonalxl.putIfAbsent(xl, new HashSet<>());
            diagonalxl.get(xl).add(p);
            int xr = c+r;
            diagonalxr.putIfAbsent(xr, new HashSet<>());
            diagonalxr.get(xr).add(p);
        }

        int[] res = new int[queries.length];
        int[][] DIRECTIONS = new int[][]{{0, 0}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1], p = r*N+c;
            if (horizon.containsKey(r) ||
                    verticle.containsKey(c) ||
                    diagonalxl.containsKey(c-r) ||
                    diagonalxr.containsKey(c+r)) {
                res[i] = 1;

                for (int[] d : DIRECTIONS) {
                    int nr = r+d[0], nc = c+d[1], np = nr*N+nc;
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }
                    if (horizon.containsKey(nr)) {
                        horizon.get(nr).remove(np);
                        if (horizon.get(nr).isEmpty()) {
                            horizon.remove(nr);
                        }
                    }
                    if (verticle.containsKey(nc)) {
                        verticle.get(nc).remove(np);
                        if (verticle.get(nc).isEmpty()) {
                            verticle.remove(nc);
                        }
                    }
                    if (diagonalxl.containsKey(nc-nr)) {
                        diagonalxl.get(nc-nr).remove(np);
                        if (diagonalxl.get(nc-nr).isEmpty()) {
                            diagonalxl.remove(nc-nr);
                        }
                    }
                    if (diagonalxr.containsKey(nc+nr)) {
                        diagonalxr.get(nc+nr).remove(np);
                        if (diagonalxr.get(nc+nr).isEmpty()) {
                            diagonalxr.remove(nc+nr);
                        }
                    }
                }
            }
        }
        return res;
    }
}
