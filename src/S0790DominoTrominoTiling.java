import java.util.HashMap;

public class S0790DominoTrominoTiling {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int numTilings(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        if (N == 0) {
            map.put(0, 1);
            return 1;
        } else if (N == 1) {
            map.put(1, 1);
            return 1;
        } else if (N == 2) {
            map.put(2, 2);
            return 2;
        }

        long res = 0;
        // v
        res += numTilings(N-1);
        // h
        res += numTilings(N-2);
        // |-
        for (int i = 2; i < N; i++) {
            res += 2*numTilings(N-i-1);
        }
        res = res%((long)Math.pow(10, 9) + 7);
        map.put(N, (int)res);
        return (int)res;
    }
}
