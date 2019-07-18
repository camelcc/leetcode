public class S1030MatrixCellsDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int MAX = Math.max(r0, R-r0-1)+Math.max(c0, C-c0-1);
        int[][] res = new int[R*C][2];
        res[0] = new int[]{r0, c0};
        int p = 1, radius = 1;
        while (radius <= MAX) {
            for (int x = 0; x <= radius; x++) {
                int y = radius-x;
                int[][] pos = null;
                if (x == 0) {
                    pos = new int[][]{{r0-y, c0}, {r0+y, c0}};
                } else if (y == 0) {
                    pos = new int[][]{{r0, c0-x}, {r0, c0+x}};
                } else {
                    pos = new int[][]{{r0-y, c0-x}, {r0-y, c0+x}, {r0+y, c0-x}, {r0+y, c0+x}};
                }

                for (int[] xy : pos) {
                    if (xy[0] < 0 || xy[0] >= R || xy[1] < 0 || xy[1] >= C) {
                        continue;
                    }
                    res[p++] = xy;
                }
            }
            radius++;
        }
        return res;
    }
}
