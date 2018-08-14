import java.util.HashMap;

public class S0343IntegerBreak {
    private HashMap<Integer, Integer> m = new HashMap<>();

    public int integerBreak(int n) {
        if (m.containsKey(n)) {
            return m.get(n);
        }

        int max = 1;
        for (int i = 1; i <= n/2; i++) {
            int m = i * Math.max(n-i, integerBreak(n-i));
            if (m > max) {
                max = m;
            }
        }

        m.put(n, max);
        return max;
    }
}
