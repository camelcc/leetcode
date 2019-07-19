import java.util.HashSet;

public class S1041RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int r = 0, c = 0, dir = 0; // 0 - north, 1 - east, 2 - south, 3 - west
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                char ch = instructions.charAt(j);
                if (ch == 'G') {
                    if (dir == 0) {
                        r--;
                    } else if (dir == 1) {
                        c++;
                    } else if (dir == 2) {
                        r++;
                    } else if (dir == 3) {
                        c--;
                    }
                } else if (ch == 'L') {
                    dir = (dir-1+4)%4;
                } else if (ch == 'R') {
                    dir = (dir+1)%4;
                }
                String t = r+","+c+","+dir+","+j;
                if (visited.contains(t)) {
                    return true;
                }
                visited.add(t);
            }
        }
        return false;
    }
}
