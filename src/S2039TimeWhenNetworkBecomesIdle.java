import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class S2039TimeWhenNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        LinkedList<Integer> bfs = new LinkedList<>();
        distance[0] = 0;
        bfs.offer(0);
        while (!bfs.isEmpty()) {
            int node = bfs.poll();
            int dist = distance[node];
            for (int ad : adj[node]) {
                if (dist+1 < distance[ad]) {
                    distance[ad] = dist+1;
                    bfs.offer(ad);
                }
            }
        }

        int res = 0;
        for(int i = 1; i < patience.length; i++){
            int dist = 2*distance[i];
            int val = dist + dist - (dist % patience[i]);
            if(dist % patience[i] == 0) val -= patience[i];
            res = Integer.max(res, val);
        }

        return res + 1;
    }
}
