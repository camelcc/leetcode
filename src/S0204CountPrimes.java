import java.util.ArrayList;
import java.util.List;

public class S0204CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        List<Integer> prims = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int p : prims) {
                if (p*p > i) {
                    break;
                }
                if (i%p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prims.add(i);
            }
        }
        return prims.size();
    }
}
