import java.util.ArrayList;
import java.util.List;

public class S0841KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        List<Integer> bfs = new ArrayList<>();
        bfs.add(0);
        while (!bfs.isEmpty()) {
            int room = bfs.remove(0);
            visited[room] = true;
            for (int r : rooms.get(room)) {
                if (!visited[r]) {
                    bfs.add(r);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
