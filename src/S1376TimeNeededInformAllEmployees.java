import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class S1376TimeNeededInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, HashSet<Integer>> directs = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            // manager[i] -> i
            int m = manager[i];
            directs.putIfAbsent(m, new HashSet<>());
            directs.get(m).add(i);
        }
        // start from headID
        int res = 0;
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{headID, 0});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int m = t[0], time = t[1];
            res = Math.max(res, time);
            for (int c : directs.getOrDefault(m, new HashSet<>())) {
                bfs.offer(new int[]{c, time+informTime[m]});
            }
        }
        return res;
    }
}
