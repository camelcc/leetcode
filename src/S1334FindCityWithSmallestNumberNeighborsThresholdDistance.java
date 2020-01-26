import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class S1334FindCityWithSmallestNumberNeighborsThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        int res = -1, connected = n;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> visited = new HashMap<>();

            LinkedList<int[]> bfs = new LinkedList<>();
            bfs.offer(new int[]{i, distanceThreshold});
            while (!bfs.isEmpty()) {
                int[] t = bfs.poll();
                int city = t[0], d = t[1];
                if (visited.containsKey(city) && visited.get(city) >= d) {
                    continue;
                }
                visited.put(city, d);

                for (int c = 0; c < n; c++) {
                    if (distance[city][c] == 0 || distance[city][c] > d) {
                        continue;
                    }
                    bfs.offer(new int[]{c, d-distance[city][c]});
                }
            }

            int c = visited.size()-1;
            if (c <= connected) {
                connected = c;
                if (i > res) {
                    res = i;
                }
            }
        }

        return res;
    }
}
