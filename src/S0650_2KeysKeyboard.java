import java.util.HashMap;

public class S0650_2KeysKeyboard {
    HashMap<Integer, Integer> steps;

    public int minSteps(int n) {
        steps = new HashMap<>();
        steps.put(1, 0);
        return steps(n);
    }

    private int steps(int n) {
        if (steps.containsKey(n)) {
            return steps.get(n);
        }

        int res = n;
        int t = 1;
        for (int i = 2; i < n && t < res; i++) {
            t++;
            if (n%i != 0) {
                continue;
            }
            res = Math.min(res, steps(n/i)+t);
        }
        steps.put(n, res);
        return res;
    }
}
