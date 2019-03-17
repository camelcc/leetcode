import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0822CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        List<Integer> value = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        List<Boolean> front = new ArrayList<>();
        for (int i = 0; i < fronts.length; i++) {
            int fv = fronts[i];
            int p = Collections.binarySearch(value, fv);
            if (p < 0) {
                p = -(p+1);
            }
            value.add(p, fv);
            index.add(p, i);
            front.add(p, true);
        }
        for (int i = 0; i < backs.length; i++) {
            int bv = backs[i];
            int p = Collections.binarySearch(value, bv);
            if (p < 0) {
                p = -(p+1);
            }
            value.add(p, bv);
            index.add(p, i);
            front.add(p, false);
        }

        for (int i = 0; i < value.size(); i++) {
            if (valid(fronts, backs, index.get(i), front.get(i))) {
                return value.get(i);
            }
        }

        return 0;
    }

    private boolean valid(int[] fronts, int[] backs, int index, boolean front) {
        assert index >= 0 && index < fronts.length;
        if (fronts[index] == backs[index]) {
            return false;
        }
        int v = front ? fronts[index] : backs[index];

        for (int i = 0; i < fronts.length; i++) {
            if (i == index) {
                continue;
            }
            if (v == fronts[i] && v == backs[i]) {
                return false;
            }
        }
        return true;
    }
}
