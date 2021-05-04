import java.util.HashMap;

public class S1687DeliveringBoxesStoragePorts {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length, need = 0, j = 0, lastj = 0, dp[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            while (j < n && maxBoxes > 0 && maxWeight >= boxes[j][1]) {
                maxBoxes -= 1;
                maxWeight -= boxes[j][1];
                if (j == 0 || boxes[j][0] != boxes[j - 1][0]) {
                    lastj = j;
                    need++;
                }
                dp[++j] = 200000;
            }
            dp[j] = Math.min(dp[j], dp[i] + need + 1);
            dp[lastj] = Math.min(dp[lastj], dp[i] + need);
            maxBoxes += 1;
            maxWeight += boxes[i][1];
            if (i == n - 1 || boxes[i][0] != boxes[i + 1][0]) {
                need--;
            }
        }
        return dp[n];
    }
}
