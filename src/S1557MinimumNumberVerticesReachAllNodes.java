import java.util.ArrayList;
import java.util.List;

public class S1557MinimumNumberVerticesReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge: edges) {
            indegree[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
