import java.util.PriorityQueue;

public class S1029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int cntA = 0, cntB = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>((Integer o1, Integer o2) -> {
            int diff1 = Math.abs(costs[o1][0]-costs[o1][1]);
            int diff2 = Math.abs(costs[o2][0]-costs[o2][1]);
            return diff1-diff2;
        });
        for (int i = 0; i < costs.length; i++) {
            if (costs[i][0] <= costs[i][1]) {
                res += costs[i][0];
                cntA++;
            } else {
                res += costs[i][1];
                cntB++;
            }
            min.offer(i);
        }
        while (!min.isEmpty() && cntA != cntB) {
            int t = min.poll();
            if (cntA > cntB) {
                if (costs[t][0] <= costs[t][1]) { // A
                    res += costs[t][1] - costs[t][0];
                    cntA--;
                    cntB++;
                }
            } else if (cntA < cntB) {
                if (costs[t][0] > costs[t][1]) { // B
                    res += costs[t][0] - costs[t][1];
                    cntA++;
                    cntB--;
                }
            }
        }
        return res;
    }
}
