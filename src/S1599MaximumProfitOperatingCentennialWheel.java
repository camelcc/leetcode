import java.util.LinkedList;

public class S1599MaximumProfitOperatingCentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int res = -1;
        int pro = 0;
        int remains = 0;
        int curPro = 0;
        int rotate = 0;
        for (int c : customers) {
            remains += c;
            curPro += (Math.min(remains, 4))*boardingCost - runningCost;
            rotate++;
            if (curPro > pro) {
                pro = curPro;
                res = rotate;
            }
            remains = Math.max(remains-4, 0);
        }
        while (remains > 0) {
            curPro += (Math.min(remains, 4))*boardingCost - runningCost;
            rotate++;
            if (curPro > pro) {
                pro = curPro;
                res = rotate;
            }
            remains = Math.max(remains-4, 0);
        }
        return res;
    }
}
