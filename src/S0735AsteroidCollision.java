import java.util.ArrayList;
import java.util.List;

public class S0735AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> asters = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            asters.add(asteroids[i]);
        }
        int i = 0;
        while (i < asters.size()) {
            if (asters.get(i) < 0) {
                i++;
                continue;
            }
            if (i+1 >= asters.size()) {
                break;
            }
            if (asters.get(i+1) > 0) {
                i++;
                continue;
            }

            // [i] > 0 && [i+1] < 0
            if (Math.abs(asters.get(i)) > Math.abs(asters.get(i+1))) {
                asters.remove(i+1);
            } else if (Math.abs(asters.get(i)) == Math.abs(asters.get(i+1))) {
                asters.remove(i+1);
                asters.remove(i);
                if (i > 0) {
                    i--;
                }
            } else {
                asters.remove(i);
                if (i > 0) {
                    i--;
                }
            }
        }
        int[] res = new int[asters.size()];
        i = 0;
        for (; i < asters.size(); i++) {
            res[i] = asters.get(i);
        }
        return res;
    }
}
