import java.util.HashSet;

public class S1015SmallestIntegerDivisibleK {
    public int smallestRepunitDivByK(int K) {
        if (K%2 == 0 || K%5 == 0) {
            return -1;
        }

        int v = 1, res = 1;
        HashSet<Integer> visited = new HashSet<>();
        while (!visited.contains(v)) {
            visited.add(v);
            while (v < K) {
                v = 10*v+1;
                res++;
            }
            // v >= K
            if (v%K == 0) {
                return res;
            }
            v = v%K;
        }
        return -1;
    }
}
