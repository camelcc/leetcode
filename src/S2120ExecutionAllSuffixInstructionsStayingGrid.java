import java.util.LinkedList;

public class S2120ExecutionAllSuffixInstructionsStayingGrid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        LinkedList<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            bfs.offer(new int[]{startPos[0], startPos[1], i, i, 0});
        }
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1], i = t[2], p = t[3], step = t[4];
            res[i] = step;

            char d = s.charAt(p);
            if (d == 'L') {
                c--;
            } else if (d == 'R') {
                c++;
            } else if (d == 'U') {
                r--;
            } else if (d == 'D') {
                r++;
            }
            if (c < 0 || c >= n || r < 0 || r >= n) {
                continue;
            }
            if (p == s.length()-1) {
                res[i] = step+1;
                continue;
            }
            bfs.offer(new int[]{r, c, i, p+1, step+1});
        }
        return res;
    }
}
