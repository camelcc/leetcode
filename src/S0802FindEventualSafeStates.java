import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0802FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        boolean find = true;
        while (find) {
            find = false;
            for (int i = 0; i < graph.length; i++) {
                if (graph[i] == null || graph[i].length > 0) {
                    continue;
                }
                // graph[i].length == 0
                find = true;
                res.add(i);
                graph[i] = null;

                for (int j = 0; j < graph.length; j++) {
                    if (graph[j] == null) {
                        continue;
                    }

                    int index = Arrays.binarySearch(graph[j], i);
                    if (index < 0) {
                        continue;
                    }
                    int[] t = new int[graph[j].length-1];
                    int m = 0;
                    for (int k = 0; k < graph[j].length; k++) {
                        if (k == index) {
                            continue;
                        }
                        t[m++] = graph[j][k];
                    }
                    graph[j] = t;
                }

                break;
            }
            if (!find) {
                break;
            }

        }
        res.sort(Integer::compareTo);
        return res;
    }
}
