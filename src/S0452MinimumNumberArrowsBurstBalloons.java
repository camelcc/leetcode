import java.util.Arrays;
import java.util.Comparator;

public class S0452MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[] bursted = new boolean[points.length];
        int count = 0;
        int remains = points.length;
        int firstAvailableBalloon = 0;
        while (remains > 0) {
            while (bursted[firstAvailableBalloon]) {
                firstAvailableBalloon++;
            }
            assert firstAvailableBalloon < points.length;

            int start = points[firstAvailableBalloon][0];
            int end = points[firstAvailableBalloon][1];

            count++;
            bursted[firstAvailableBalloon] = true;
            remains--;

            // burst as much as possible
            int others = firstAvailableBalloon + 1;
            while (others < points.length && points[others][0] <= end) {
                bursted[others] = true;
                start = Math.max(start, points[others][0]);
                end = Math.min(end, points[others][1]);
                remains--;
                others++;
            }
        }

        return count;
    }
}
