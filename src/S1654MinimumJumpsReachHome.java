public class S1654MinimumJumpsReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int up = Math.max(2001, x + a*b);
        Integer[] forward = new Integer[up];
        Integer[] all = new Integer[up];
        boolean[] visited = new boolean[up];
        forward[x] = 0;
        all[x] = 0;
        for (int f : forbidden) {
            visited[f] = true;
        }
        return dp(a, b, up, visited, forward, all, 0, 1);
    }

    // 0 - forward only, 1 - both
    private int dp(int a, int b, int up,
                   boolean[] visited, Integer[] forward, Integer[] all, int p, int direction) {
        if (p >= up || p < 0) {
            return -1;
        }
        int res = -1;
        if (forward[p] == null) {
            if (p+a >= up || visited[p+a]) {
                forward[p] = -1;
            } else {
                visited[p] = true;
                int t = dp(a, b, up, visited, forward, all, p+a, 1);
                visited[p] = false;
                if (t == -1) {
                    forward[p] = -1;
                } else {
                    forward[p] = t + 1;
                }
            }
        }
        res = forward[p];
        if (direction == 0) {
            return res;
        }
        if (all[p] != null) {
            return all[p];
        }
        if (p-b < 0 || visited[p-b]) {
            all[p] = res;
            return res;
        }
        visited[p-a] = true;
        int t = dp(a, b, up, visited, forward, all, p-b, 0);
        if (t == -1) {
            all[p] = res;
            return res;
        }
        if (res == -1) {
            res = t+1;
        } else {
            res = Math.min(res, t+1);
        }
        all[p] = res;
        return res;
    }
}
