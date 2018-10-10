import java.util.HashMap;

public class S0447NumberBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> distances = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }

                int d = squareDis(points[i], points[j]);
                distances.put(d, distances.getOrDefault(d, 0) + 1);
            }
            for (int booms : distances.values()) {
                res += booms * (booms - 1);
            }
        }

        return res;
    }

    private int squareDis(int[] a, int[] b) {
        int dx = Math.abs(a[0]-b[0]);
        int dy = Math.abs(a[1]-b[1]);
        return dx*dx + dy*dy;
    }
}
