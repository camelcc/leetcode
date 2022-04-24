public class S2249CountLatticePointsInsideCircle {
    public int countLatticePoints(int[][] circles) {
        int GAP = 150;
        boolean[][] valid = new boolean[400][400];
        for (int[] circle: circles) {
            int x = circle[0]+GAP, y = circle[1]+GAP, rad = circle[2];
            for (int r = y-rad+GAP; r <= y+rad+GAP; r++) {
                for (int c = x-rad+GAP; c <= x+rad+GAP; c++) {
                    if (valid[r][c]) {
                        continue;
                    }

                    int d = (r-y)*(r-y) + (c-x)*(c-x);
                    if (d <= rad*rad) {
                        valid[r][c] = true;
                    }
                }
            }
        }

        int res = 0;
        for (int r = 0; r < valid.length; r++) {
            for (int c = 0; c < valid[0].length; c++) {
                if (valid[r][c]) {
                    res++;
                }
            }
        }
        return res;
    }
}
