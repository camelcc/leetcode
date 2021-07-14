import java.util.*;

// https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/discuss/1332005/Java-Dijkstras-100-Faster-100-Memory
public class S1928MinimumCostReachDestinationTime {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        HashMap<Integer, Integer>[] adjs = new HashMap[passingFees.length];
        for (int i = 0; i < passingFees.length; i++) {
            adjs[i] = new HashMap<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], t = edge[2];
            if (adjs[x].getOrDefault(y, 1001) > t) {
                adjs[x].put(y, t);
            }
            if (adjs[y].getOrDefault(x, 1001) > t) {
                adjs[y].put(x, t);
            }
        }

        int[] minTime = new int[passingFees.length];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{0, passingFees[0], 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int node = t[0], cost = t[1], time = t[2];
            if (time > maxTime || time >= minTime[node]) {
                continue;
            }
            if (node == passingFees.length-1) {
                return cost;
            }
            minTime[node] = time;
            for (int adj : adjs[node].keySet()) {
                pq.offer(new int[]{adj, cost+passingFees[adj], time+adjs[node].get(adj)});
            }
        }
        return -1;
    }
}
