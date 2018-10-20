import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class S0874WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Integer> ob = new HashSet<>();
        for (int[] o : obstacles) {
            ob.add(o[0]*30000+o[1]);
        }

        int max = 0;
        int x = 0;
        int y = 0;
        int direction = 0; // 0 - up, 1 - right, 2 - down, 3 - left
        for (int c : commands) {
            if (c == -2) {
                direction = (direction - 1 + 4) % 4;
            } else if (c == -1) {
                direction = (direction + 1) % 4;
            } else if (c >= 1 && c <= 9) {
                for (int i = 0; i < c; i++) {
                    int nx = x;
                    int ny = y;
                    if (direction == 0) {
                        ny++;
                    } else if (direction == 1) {
                        nx++;
                    } else if (direction == 2) {
                        ny--;
                    } else if (direction == 3) {
                        nx--;
                    }
                    if (ob.contains(nx*30000+ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    if (max < x*x+y*y) {
                        max = x*x+y*y;
                    }
                }
            }
        }
        return max;
    }
}
