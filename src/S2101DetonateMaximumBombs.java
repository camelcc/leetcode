import java.util.LinkedList;

public class S2101DetonateMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            res = Math.max(res, max(bombs, i));
        }
        return res;
    }

    private int max(int[][] bombs, int i) {
        boolean[] detonated = new boolean[bombs.length];
        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.offer(i);
        detonated[i] = true;
        while (!bfs.isEmpty()) {
            int t = bfs.poll();
            int x = bombs[t][0], y = bombs[t][1], r = bombs[t][2];
            for (int j = 0; j < bombs.length; j++) {
                if (detonated[j]) {
                    continue;
                }
                long dx = x-bombs[j][0], dy = y-bombs[j][1];
                if (dx*dx+dy*dy > ((long)r)*r) {
                    continue;
                }
                bfs.offer(j);
                detonated[j] = true;
            }
        }
        int res = 0;
        for (int j = 0; j < detonated.length; j++) {
            if (detonated[j]) {
                res++;
            }
        }
        return res;
    }
}
