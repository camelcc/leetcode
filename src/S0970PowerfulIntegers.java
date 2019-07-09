import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0970PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> res = new HashSet<>();
        if (bound < 2) {
            return new ArrayList<>(res);
        }
        res.add(2);
        if (bound == 2 || (x == 1 && y == 1)) {
            return new ArrayList<>(res);
        } else if (x == 1) {
            int v = y;
            while (1 + v <= bound) {
                res.add(1+v);
                v *= y;
            }
        } else if (y == 1) {
            int v = x;
            while (1 + v <= bound) {
                res.add(1 + v);
                v *= x;
            }
        } else {
            // x >= 2, y >= 2
            int xv = 1;
            while (xv < bound) {
                int yv = 1;
                while (xv + yv <= bound) {
                    res.add(xv + yv);
                    yv *= y;
                }
                xv *= x;
            }
        }
        return new ArrayList<>(res);
    }
}
