import java.util.HashMap;
import java.util.HashSet;

public class S0447NumberBoomerangs {
    // TODO: do better
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            int[] source = points[i];

            HashMap<Integer, HashSet<Integer>> distances = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }

                int d = squareDis(source, points[j]);
                HashSet<Integer> p = distances.containsKey(d) ? distances.get(d) : new HashSet<>();
                p.add(j);
                distances.put(d, p);
            }

            for (HashSet<Integer> booms : distances.values()) {
                if (booms.size() <= 1) {
                    continue;
                }

                res += booms.size() * (booms.size() - 1);
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
