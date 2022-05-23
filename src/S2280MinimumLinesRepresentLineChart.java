import java.util.Arrays;

public class S2280MinimumLinesRepresentLineChart {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        } else if (stockPrices.length == 2) {
            return 1;
        }
        Arrays.sort(stockPrices, (o1, o2) -> o1[0]-o2[0]);

        int res = 1;
        int[] prev = stockPrices[0];
        int[] cur = stockPrices[1];
        for (int i = 2; i < stockPrices.length; i++) {
            int[] t = stockPrices[i];
            long dx = cur[0]-prev[0], dy = cur[1]-prev[1];
            long tdx = t[0]-cur[0], tdy = t[1]-cur[1];
            if (dy * tdx != dx * tdy) {
                res++;
            }

            prev = cur;
            cur = t;
        }
        return res;
    }
}
