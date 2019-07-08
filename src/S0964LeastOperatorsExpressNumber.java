import java.util.HashMap;

public class S0964LeastOperatorsExpressNumber {
    public int leastOpsExpressTarget(int x, int target) {
        if (x == target) {
            return 0;
        }
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        return ops(x, target, dp);
    }

    private int ops(int x, int target, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        if (x == target) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        int ops = 0;
        long v = x;
        while (v < target) {
            v = v*x;
            ops++;
        }
        if (v == target) {
            res = ops;
        } else if (v-target < target) {
            res = ops + 1 + ops(x, (int)(v-target), dp);
        }
        v /= x;
        res = Math.min(res, ops(x, (int)(target-v), dp)+(ops == 0 ? 2 : ops));
        dp.put(target, res);
        return res;
    }
}
