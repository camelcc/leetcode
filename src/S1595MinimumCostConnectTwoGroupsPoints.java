import java.util.List;

public class S1595MinimumCostConnectTwoGroupsPoints {
    private static int FULL_BITMASK;

    public int connectTwoGroups(List<List<Integer>> cost) {
        FULL_BITMASK = (1 << cost.get(0).size()) - 1;
        int[][][] memo = new int[cost.size()][FULL_BITMASK + 1][2];

        return find(memo, cost, 0, 0, -1, -1);
    }

    private int find(int[][][] memo, List<List<Integer>> cost, int posA, int usedB, int lastA, int lastB) {
        if(posA == cost.size())
            return usedB == FULL_BITMASK ? 0 : Integer.MAX_VALUE;

        // we have two state from each (posA, usedB)
        // first state is if we reached (posA, usedB) from a previous A point
        // second state is if we reached (posA, usedB) from the same A point
        int token = (posA == lastA) ? 0 : 1;

        if(memo[posA][usedB][token] != 0)
            return memo[posA][usedB][token];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cost.get(posA).size(); i++) {
            int mask = 1 << i;
            int res;

            // Connection from current A point -> B point (i)
            // Continue to add edges from current A point to other B points
            if((usedB & mask) == 0 && (posA != lastA || lastB < i)) {
                res = find(memo, cost, posA, usedB | mask, posA, i);
                if(res != Integer.MAX_VALUE)
                    min = Math.min(min, res + cost.get(posA).get(i));
            }

            // Connection from current A point -> B point (i)
            // Do not add futher connections from current A point, go to next A point
            res = find(memo, cost, posA + 1, usedB | mask, posA, i);
            if(res != Integer.MAX_VALUE)
                min = Math.min(min, res + cost.get(posA).get(i));
        }

        memo[posA][usedB][token] = min;
        return min;
    }
}
