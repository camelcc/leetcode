import java.util.ArrayList;
import java.util.List;

public class S0054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int direction = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        int r = 0, c = 0, i = 0;
        while (true) {
            res.add(matrix[r][c]);

            if (direction == 0) {
                if (c+1 == N-i) {
                    direction = 1;
                    if (r+1 == M-i) {
                        break;
                    }
                    r++;
                } else {
                    c++;
                }
            } else if (direction == 1) {
                if (r+1 == M-i) {
                    direction = 2;
                    if (c == i) {
                        break;
                    }
                    c--;
                } else {
                    r++;
                }
            } else if (direction == 2) {
                if (c == i) {
                    direction = 3;
                    if (r-1 == i) {
                        break;
                    }
                    r--;
                } else {
                    c--;
                }
            } else if (direction == 3) {
                if (r-1 == i) {
                    direction = 0;
                    i++;
                    if (c+1 == N-i) {
                        break;
                    }
                    c++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
