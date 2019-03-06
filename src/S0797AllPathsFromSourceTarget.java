import java.util.ArrayList;
import java.util.List;

public class S0797AllPathsFromSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<List<Integer>> bfs = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        bfs.add(t);
        int N = graph.length;
        while (!bfs.isEmpty()) {
            List<Integer> p = bfs.remove(0);
            for (int adj : graph[p.get(p.size()-1)]) {
                List<Integer> r = new ArrayList<>(p);
                r.add(adj);

                if (adj == N-1) {
                    paths.add(r);
                } else {
                    bfs.add(r);
                }
            }
        }
        return paths;
    }
}
