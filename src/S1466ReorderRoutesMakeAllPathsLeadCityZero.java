import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class S1466ReorderRoutesMakeAllPathsLeadCityZero {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, HashSet<Integer>> roads = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> reversed = new HashMap<>();
        for (int[] conn : connections) {
            roads.putIfAbsent(conn[0], new HashSet<>());
            reversed.putIfAbsent(conn[1], new HashSet<>());
            roads.get(conn[0]).add(conn[1]);
            reversed.get(conn[1]).add(conn[0]);
        }

        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.offer(0);
        while (!bfs.isEmpty()) {
            int c = bfs.poll();
            visited.add(c);
            for (int i : roads.getOrDefault(c, new HashSet<>())) {
                if (!visited.contains(i)) {
                    res++;
                    bfs.offer(i);
                }
            }
            for (int i : reversed.getOrDefault(c, new HashSet<>())) {
                if (!visited.contains(i)) {
                    bfs.offer(i);
                }
            }
        }
        return res;
    }
}
