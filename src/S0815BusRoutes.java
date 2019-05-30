import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class S0815BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, HashSet<Integer>> station = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            Arrays.sort(routes[bus]);
            for (int stop = 0; stop < routes[bus].length; stop++) {
                int s = routes[bus][stop];
                HashSet<Integer> b = station.getOrDefault(s, new HashSet<>());
                b.add(bus);
                station.put(s, b);
            }
        }
        if (!station.containsKey(S)) {
            return -1;
        }

        LinkedList<int[]> bus = new LinkedList<>();
        for (int b : station.get(S)) {
            bus.add(new int[]{b, 1});
        }
        boolean[] visited = new boolean[routes.length];

        while (!bus.isEmpty()) {
            int[] t = bus.poll();
            int b = t[0], res = t[1];
            visited[b] = true;
            if (Arrays.binarySearch(routes[b], T) >= 0) {
                return res;
            }

            for (int s : routes[b]) {
                for (int l : station.get(s)) {
                    if (!visited[l]) {
                        bus.add(new int[]{l, res+1});
                    }
                }
            }
        }
        return -1;
    }
}
