import java.util.LinkedList;

public class S2059MinimumOperationsConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        LinkedList<int[]> bfs = new LinkedList<>();
        visited[start] = true;
        bfs.offer(new int[]{start, 0});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int n = t[0], s = t[1];
            for (int i = 0; i < nums.length; i++) {
                for (int nv : new int[]{n+nums[i], n-nums[i], n^nums[i]}) {
                    if (nv == goal) {
                        return s+1;
                    }
                    if (nv < 0 || nv > 1000 || visited[nv]) { // invalid
                        continue;
                    }
                    visited[nv] = true;
                    bfs.offer(new int[]{nv, s+1});
                }
            }
        }
        return -1;
    }
}
