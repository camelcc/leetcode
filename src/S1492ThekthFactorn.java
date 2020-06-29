import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1492ThekthFactorn {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        int l = 1;
        while (l <= (int)Math.sqrt(n)) {
            if (n%l == 0) {
                factors.add(l);
                if (n/l != l) {
                    factors.add(n/l);
                }
            }
            l++;
        }
        if (factors.size() < k) {
            return -1;
        } else {
            Collections.sort(factors);
            return factors.get(k-1);
        }
    }
}
