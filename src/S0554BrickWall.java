import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0554BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.isEmpty()) {
            return 0;
        }
        if (wall.size() == 1) {
            return wall.get(0).size() == 1 ? 1 : 0;
        }
        int total = wall.size();

        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int s = 0;
            List<Integer> bs = wall.get(i);
            for (int b : bs) {
                s += b;
                if (!edges.containsKey(s)) {
                    edges.put(s, new HashSet<>());
                }
                edges.get(s).add(i);
            }
            edges.remove(s);
        }
        int max = 0;
        for (HashSet edge : edges.values()) {
            if (max < edge.size()) {
                max = edge.size();
            }
        }
        return total - max;
    }
}
