import java.util.Arrays;

import util.ListNode;

public class S2326SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int r = 0; r < m; r++) {
            Arrays.fill(res[r], -1);
        }
        ListNode node = head;
        int LEFT = 0, RIGHT = n-1, TOP = 0, BOTTOM = m-1;
        int r = 0, c = 0, dir = 0;
        // 0 - right, 1 - down, 2 - left, 3 - up
        while (node != null) {
            res[r][c] = node.val;
            node = node.next;

            if (dir == 0) {
                c++;
                if (c > RIGHT) {
                    c--;
                    r++;
                    dir = 1;
                    TOP++;
                }
            } else if (dir == 1) {
                r++;
                if (r > BOTTOM) {
                    r--;
                    c--;
                    dir = 2;
                    RIGHT--;
                }
            } else if (dir == 2) {
                c--;
                if (c < LEFT) {
                    c++;
                    r--;
                    dir = 3;
                    BOTTOM--;
                }
            } else if (dir == 3) {
                r--;
                if (r < TOP) {
                    r++;
                    c++;
                    dir = 0;
                    LEFT++;
                }
            }
        }
        return res;
    }
}
