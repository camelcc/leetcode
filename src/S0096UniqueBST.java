import java.util.HashMap;

public class S0096UniqueBST {
    //TODO: DP solution
    public int numTrees(int n) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        counts.put(1, 1);
        return gen(n, counts);
    }

    private int gen(int nums, HashMap<Integer, Integer> counts) {
        int res = 0;
        if (nums == 0) {
            return 0;
        }
        if (nums == 1) {
            return 1;
        }
        if (counts.containsKey(nums)) {
            return counts.get(nums);
        }

        for (int i = 0; i < nums; i++) {
            if (i == 0) {
                res += gen(nums-1, counts);
            } else if (i == nums-1) {
                res += gen(nums-1, counts);
            } else {
                int lefts = gen(i, counts);
                int rights = gen(nums-i-1, counts);
                res += lefts * rights;
            }
        }

        counts.put(nums, res);
        return res;
    }
}
