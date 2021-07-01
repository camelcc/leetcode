public class S1914CyclicallyRotatingGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int M = grid.length, N = grid[0].length;
        int[][] res = new int[M][N];
        int l = 0, t = 0, r = N-1, b = M-1;
        while (l < r && t < b) {
            int len = 2*(r-l)+2*(b-t);
            int lk = k%len;
            int[] before = new int[]{t,l};
            int[] after = new int[]{t,l};
            if (lk >= 0 && lk < b-t) {
                after = new int[]{t+lk, l};
            } else if (lk >= b-t && lk < (b-t)+(r-l)) {
                after = new int[]{b, l+(lk-(b-t))};
            } else if (lk >= (b-t)+(r-l) && lk < 2*(b-t)+(r-l)) {
                after = new int[]{b-(lk-(b-t)-(r-l)), r};
            } else {
                after = new int[]{t, r-(lk-2*(b-t)-(r-l))};
            }
            for (int i = 0; i < len; i++) {
                res[after[0]][after[1]] = grid[before[0]][before[1]];
                before = next(before, l, r, t, b);
                after = next(after, l, r, t, b);
            }
            l++;
            r--;
            t++;
            b--;
        }
        return res;
    }

    private int[] next(int[] current, int l, int r, int t, int b) {
        if (current[0] < b && current[1] == l) {
            return new int[]{current[0]+1, l};
        } else if (current[0] == b && current[1] == l) {
            return new int[]{b, l+1};
        } else if (current[0] == b && current[1] < r) {
            return new int[]{b, current[1]+1};
        } else if (current[0] == b && current[1] == r) {
            return new int[]{b-1, r};
        } else if (current[0] > t && current[1] == r) {
            return new int[]{current[0]-1, r};
        } else if (current[0] == t && current[1] == r) {
            return new int[]{t, r-1};
        } else {
            return new int[]{t, current[1]-1};
        }
    }
}
