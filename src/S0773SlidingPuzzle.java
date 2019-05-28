import java.util.HashSet;
import java.util.LinkedList;

public class S0773SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        HashSet<String> visited = new HashSet<>();
        LinkedList<String[]> bfs = new LinkedList<>();
        bfs.add(new String[]{comb(board), "0"});

        while (!bfs.isEmpty()) {
            String[] t = bfs.poll();
            String com = t[0];
            int steps = Integer.valueOf(t[1]);
            visited.add(com);
            if (com.equals("123450")) {
                return steps;
            }

            int p = com.indexOf('0');
            int zr = p/3, zc = p%3;
            for (int[] d : dir) {
                int r = zr+d[0];
                int c = zc+d[1];
                if (r < 0 || r >= 2 || c < 0 || c >= 3) {
                    continue;
                }
                int swap = r*3+c;
                StringBuilder sb = new StringBuilder(com);
                sb.setCharAt(p, sb.charAt(swap));
                sb.setCharAt(swap, '0');
                if (visited.contains(sb.toString())) {
                    continue;
                }

                bfs.add(new String[]{sb.toString(), String.valueOf(steps+1)});
            }
        }
        return -1;
    }

    private String comb(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                sb.append(String.valueOf(board[r][c]));
            }
        }
        return sb.toString();
    }
}
