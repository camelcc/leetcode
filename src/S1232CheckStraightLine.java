import java.util.Arrays;
import java.util.Comparator;

public class S1232CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
//        Arrays.sort(coordinates, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] != o2[0]) {
//                    return o1[0]-o2[0];
//                }
//                return o1[1]-o2[1];
//            }
//        });
        int dx = coordinates[1][0]-coordinates[0][0];
        int dy = coordinates[1][1]-coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int tdx = coordinates[i][0]-coordinates[0][0];
            int tdy = coordinates[i][1]-coordinates[0][1];
            if (dx == 0) {
                if (tdx == 0) {
                    continue;
                } else {
                    return false;
                }
            }
            if (dy == 0) {
                if (tdy == 0) {
                    continue;
                } else {
                    return false;
                }
            }
            if (tdy*dx != tdx*dy) {
                return false;
            }
        }
        return true;
    }
}
