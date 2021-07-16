import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class S1931PaintingGridWithThreeDifferentColors {
    public int colorTheGrid(int m, int n) {
        ArrayList<String> rgbs = new ArrayList<>();

        LinkedList<StringBuilder> bfs = new LinkedList<>();
        bfs.offer(new StringBuilder());
        while (!bfs.isEmpty()) {
            StringBuilder sb = bfs.poll();
            if (sb.length() == m) {
                rgbs.add(sb.toString());
                continue;
            }
            if (sb.length() == 0) {
                bfs.offer(new StringBuilder("r"));
                bfs.offer(new StringBuilder("g"));
                bfs.offer(new StringBuilder("b"));
            } else {
                char c = sb.charAt(sb.length()-1);
                for (char cur : new char[]{'r', 'g', 'b'}) {
                    if (cur != c) {
                        bfs.offer(new StringBuilder(sb).append(cur));
                    }
                }
            }
        }
        if (n == 1) {
            return rgbs.size();
        }

        int cnt = rgbs.size();
        boolean[][] adj = new boolean[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            for (int j = i+1; j < cnt; j++) {
                // rgbs[i], rgbs[j]
                boolean good = true;
                for (int k = 0; k < m; k++) {
                    if (rgbs.get(i).charAt(k) == rgbs.get(j).charAt(k)) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
        }

        int MOD = 1_000_000_007;
        long[] res = new long[cnt];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            long[] next = new long[cnt];
            for (int j = 0; j < cnt; j++) {
                for (int k = 0; k < cnt; k++) {
                    if (!adj[j][k]) {
                        continue;
                    }
                    next[k] += res[j];
                    next[k] = next[k]%MOD;
                }
            }
            res = next;
        }
        long r = 0;
        for (long v : res) {
            r += v;
            r = r%MOD;
        }
        return (int)r;
    }
}
