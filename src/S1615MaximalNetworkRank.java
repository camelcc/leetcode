import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.ToIntFunction;

public class S1615MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(i);
            graph[roads[i][1]].add(i);
        }
        Arrays.sort(graph, Comparator.comparingInt((ToIntFunction<HashSet<Integer>>) HashSet::size).reversed());
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (graph[i].size() + graph[j].size() <= res) {
                    break;
                }
                HashSet<Integer> t = new HashSet<>(graph[i]);
                t.addAll(graph[j]);
                res = Math.max(res, t.size());
            }
            if (graph[i].size() * 2 <= res) {
                break;
            }
        }
        return res;
    }
}
