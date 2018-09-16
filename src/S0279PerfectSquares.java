import java.util.HashMap;

public class S0279PerfectSquares {
    public int numSquares(int n) {
        return squares(n, new HashMap<>());
    }

    private int squares(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int maxSquare = (int)Math.sqrt(n);
        if (maxSquare == 1) {
            map.put(n, n);
            return n;
        }
        if (maxSquare * maxSquare == n) {
            map.put(n, 1);
            return 1;
        }

        int sqs = n;
        for (int i = maxSquare; i >= 1; i--) {
            int s = squares(n-i*i, map) + 1;
            if (s < sqs) {
                sqs = s;
            }
        }
        map.put(n, sqs);
        return sqs;
    }
}
