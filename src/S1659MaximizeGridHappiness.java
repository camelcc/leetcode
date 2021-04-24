import java.util.HashMap;

public class S1659MaximizeGridHappiness {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {

        return helper(m, n, 0, 0, introvertsCount, extrovertsCount, 0,
                new Integer[m][n][introvertsCount + 1][extrovertsCount + 1][243]);
    }

    // Ternary get ith bit value (0, 1 or 2)
    private int get(int prevN, int i) {
        prevN /= ((int) Math.pow(3, i));
        return prevN % 3;
    }

    // Ternary set new-coming bit to value
    private int set(int currRow, int value) {
        return (currRow * 3 + value) % 243;
    }

    // Ternary bit meaning -> empty: 0, intro: 1, extro: 2
    private int helper(int m, int n, int x, int y, int iCount, int eCount,
                       int prevN, Integer[][][][][] dp) {

        // advance pointer
        if (y == n) {
            y = 0;
            x++;
        }

        if (iCount == 0 && eCount == 0) return 0;

        if (x == m) return 0;

        if (dp[x][y][iCount][eCount][prevN] != null) return dp[x][y][iCount][eCount][prevN];

        // leave the cell empty
        int res = helper(m, n, x, y + 1, iCount, eCount, set(prevN, 0), dp);

        int up = get(prevN, n - 1);  // get up bit -> which is at (n - 1)th
        int left = get(prevN, 0);  // get left bit -> which is at (0)th

        if (iCount > 0) {  // put intro guy at current cell

            int temp = prevN;
            prevN = set(prevN, 1);  // set new-coming bit to 1

            int addOn = 120;

            if (x - 1 >= 0 && up != 0) {
                addOn -= 30;
                if (up == 1) addOn -= 30;
                else addOn += 20;
            }

            if (y - 1 >= 0 && left != 0) {
                addOn -= 30;
                if (left == 1) addOn -= 30;
                else addOn += 20;
            }

            res = Math.max(res, helper(m, n, x, y + 1, iCount - 1, eCount, prevN, dp) + addOn);

            prevN = temp;  // set it back
        }

        if (eCount > 0) {  // put extro guy at current cell

            int temp = prevN;
            prevN = set(prevN, 2);  // set new-coming bit to 2

            int addOn = 40;

            if (x - 1 >= 0 && up != 0) {
                addOn += 20;
                if (up == 1) addOn -= 30;
                else addOn += 20;
            }

            if (y - 1 >= 0 && left != 0) {
                addOn += 20;
                if (left == 1) addOn -= 30;
                else addOn += 20;
            }

            res = Math.max(res, helper(m, n, x, y + 1, iCount, eCount - 1, prevN, dp) + addOn);

            prevN = temp;  // set it back
        }

        return dp[x][y][iCount][eCount][prevN] = res;
    }
}
