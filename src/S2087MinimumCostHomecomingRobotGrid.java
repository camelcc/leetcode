import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S2087MinimumCostHomecomingRobotGrid {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        if (startPos[0] < homePos[0]) {
            for (int i = startPos[0]+1; i <= homePos[0]; i++) {
                res += rowCosts[i];
            }
        } else if (startPos[0] > homePos[0]) {
            for (int i = startPos[0]-1; i >= homePos[0]; i--) {
                res += rowCosts[i];
            }
        }
        if (startPos[1] < homePos[1]) {
            for (int i = startPos[1]+1; i <= homePos[1]; i++) {
                res += colCosts[i];
            }
        } else if (startPos[1] > homePos[1]) {
            for (int i = startPos[1]-1; i >= homePos[1]; i--) {
                res += colCosts[i];
            }
        }
        return res;
    }
}
