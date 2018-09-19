import java.util.ArrayList;
import java.util.List;

public class S0313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        int[] primeIndex = new int[primes.length];
        int count = 1;
        int res = 1;

        while (count < n) {
            // compute value set to res
            int m = Integer.MAX_VALUE;
            List<Integer> minIndexs = new ArrayList<>();
            for (int i = 0; i < primes.length; i++) {
                int v = primes[i] * queue.get(primeIndex[i]);
                if (m > v) {
                    minIndexs.clear();
                    minIndexs.add(i);
                    m = v;
                } else if (m == v) {
                    minIndexs.add(i);
                }
            }
            queue.add(m);
            count++;
            res = m;
            for (int i : minIndexs) {
                primeIndex[i]++;
            }
            if (min(primeIndex) > 0) {
                queue.remove(0);
                for (int i = 0; i < primeIndex.length; i++) {
                    primeIndex[i]--;
                }
            }
        }

        return res;
    }

    private int min(int[] indexs) {
        int m = Integer.MAX_VALUE;
        for (int i : indexs) {
            if (m > i) {
                m = i;
            }
        }
        return m;
    }
}
