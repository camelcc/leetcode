import java.util.HashSet;

public class S1036EscapeLargeMaze {
    int MAX = 20000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(b[0]+","+b[1]);
        }
        return canVisit(block, source, target) &&
                canVisit(block, target, source);
    }

    private boolean canVisit(HashSet<String> blocked, int[] source, int[] target) {
        HashSet<String> visited = new HashSet<>();
        return dfs(blocked, visited, source[0], source[1], target[0]+","+target[1]);
    }

    private boolean dfs(HashSet<String> blocked, HashSet<String> visited, int r, int c, String target) {
        visited.add(r+","+c);
        if (visited.contains(target) || visited.size() >= MAX) {
            return true;
        }
        for (int[] d : new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}}) {
            int dr = r + d[0], dc = c + d[1];
            String ds = dr+","+dc;
            if (dr < 0 || dr >= 1000000 || dc < 0 || dc >= 1000000 || visited.contains(ds) || blocked.contains(ds)) {
                continue;
            }
            if (dfs(blocked, visited, r+d[0], c+d[1], target)) {
                return true;
            }
        }
        return false;
    }
}
