import java.util.HashSet;

public class S1496PathCrossing {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y--;
            } else if (c == 'S') {
                y++;
            } else if (c == 'E') {
                x--;
            } else if (c == 'W') {
                x++;
            }
            String p = x+","+y;
            if (visited.contains(p)) {
                return true;
            }
            visited.add(p);
        }
        return false;
    }
}
