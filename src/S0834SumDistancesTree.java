import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0834SumDistancesTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<HashSet<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjs.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }

        int[] cnt = new int[N];
        int[] dis = new int[N];
        count(0, -1, cnt, dis, adjs);
        distance(0, -1, cnt, dis, adjs);
        return dis;
    }

    private void count(int root, int parent, int[] cnt, int[] dis, List<HashSet<Integer>> adjs) {
        for (int adj : adjs.get(root)) {
            if (adj == parent) {
                continue;
            }
            count(adj, root, cnt, dis, adjs);
            cnt[root] += cnt[adj];
            dis[root] += cnt[adj]+dis[adj];
        }
        cnt[root]++;
    }

    private void distance(int root, int parent, int[] cnt, int[] dis, List<HashSet<Integer>> adjs) {
        for (int adj : adjs.get(root)) {
            if (adj == parent) {
                continue;
            }
            dis[adj] = dis[root] - cnt[adj] + cnt.length - cnt[adj];
            distance(adj, root, cnt, dis, adjs);
        }
    }
}
