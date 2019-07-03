import java.util.*;

public class S0952LargestComponentSizeCommonFactor {
    int max = 0;
    public int largestComponentSize(int[] A) {
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        // all primes less than 100000
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2; j * i <= 100000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int n = A.length;
        int[] counts = new int[n];
        int[] parents = new int[n];
        int[] primeToIndex = new int[100001];
        Arrays.fill(primeToIndex, -1);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            counts[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int p : primes) {
                if (primes.contains(a)) { // Optimization
                    p = a;
                }
                if (a % p == 0) {
                    if (primeToIndex[p] > -1) {
                        union(parents, counts, primeToIndex[p], i);
                    }
                    primeToIndex[p] = i;
                    while (a % p == 0) {
                        a /= p;
                    }
                }
                if (a == 1) {
                    break;
                }
            }
        }
        return max;
    }
    private int find(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = find(parents, parents[a]);
        }
        return parents[a];
    }
    private void union(int[] parents, int[] counts, int a, int b) {
        int root1 = find(parents, a), root2 = find(parents, b);
        if (root1 == root2) {
            return;
        }
        int count = counts[root2] + counts[root1];
        max = Math.max(count, max);
        parents[root1] = root2;
        counts[root2] = count;
    }
}
