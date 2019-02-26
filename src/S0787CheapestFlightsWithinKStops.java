import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int N = K+2;
        int[][] prices = new int[n][N];
        for (int i = 0; i < n; i++) {
            Arrays.fill(prices[i], -1);
        }
        prices[src][N-1] = 0;
        List<Integer> bfs = new ArrayList<>();
        bfs.add(src*N+N-1);

        while (!bfs.isEmpty()) {
            int t = bfs.remove(0);
            int tsrc = t/N;
            int tK = t%N;
            int tPrice = prices[tsrc][tK];
            assert tK > 0;

            for (int[] flight : flights) {
                if (flight[0] != tsrc) {
                    continue;
                }
                int tdst = flight[1];

                boolean valid = true;
                for (int i = tK-1; i < N; i++) {
                    if (prices[tdst][i] != -1 && prices[tdst][i] <= tPrice + flight[2]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    prices[tdst][tK-1] = tPrice + flight[2];
                    if (tK-1 > 0 && tdst != dst && !bfs.contains(tdst*N+tK-1)) {
                        bfs.add(tdst*N+tK-1);
                    }
                }
            }
        }

        int res = -1;
        for (int i = 0; i < N; i++) {
            if (prices[dst][i] != -1) {
                if (res == -1) {
                    res = prices[dst][i];
                } else {
                    res = Math.min(prices[dst][i], res);
                }
            }
        }
        return res;
    }
}
