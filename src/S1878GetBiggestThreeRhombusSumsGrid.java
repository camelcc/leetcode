import java.util.HashSet;

public class S1878GetBiggestThreeRhombusSumsGrid {
    public int[] getBiggestThree(int[][] grid) {
        int s1 = 0, s2 = 0, s3 = 0;
        int M = grid.length, N = grid[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                HashSet<Integer> sum = new HashSet<>();
                int left = c, right = c, row = r, s = 0;
                while (left >= 0 && right < N) {
                    int nl = left, nr = right, rr = row, ns = s;
                    while (nl >= 0 && nr < N && rr < M) {
                        if (nl == nr) {
                            ns += grid[rr][nl];
                            break;
                        } else {
                            ns += grid[rr][nl];
                            ns += grid[rr][nr];
                        }
                        nl++;
                        nr--;
                        rr++;
                    }
                    if (rr >= M || nl != nr) {
                        break;
                    }
                    sum.add(ns);

                    if (left == right) {
                        s += grid[row][left];
                    } else {
                        s += grid[row][left];
                        s += grid[row][right];
                    }

                    left--;
                    right++;
                    row++;
                }
                for (int t : sum) {
                    if (t > s1) {
                        s3 = s2;
                        s2 = s1;
                        s1 = t;
                    } else if (t == s1) {
                    } else if (t > s2) {
                        s3 = s2;
                        s2 = t;
                    } else if (t == s2) {
                    } else if (t > s3) {
                        s3 = t;
                    }
                }
            }
        }
        if (s2 == 0) {
            return new int[]{s1};
        } else if (s3 == 0) {
            return new int[]{s1, s2};
        } else {
            return new int[]{s1, s2, s3};
        }
    }
}
