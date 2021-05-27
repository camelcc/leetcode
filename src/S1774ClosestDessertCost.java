import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class S1774ClosestDessertCost {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int res = baseCosts[0], diff = Math.abs(res-target);

        List<Integer> pre = new ArrayList<>();
        pre.add(0);
        for (int t : toppingCosts) {
            List<Integer> next = new ArrayList<>(pre);
            for (int p : pre) {
                next.add(p+t);
                next.add(p+t+t);
            }
            pre = next;
        }
        TreeSet<Integer> top = new TreeSet<>(pre);
        if (toppingCosts.length == 1) {
            top.add(toppingCosts[0]);
            top.add(toppingCosts[0]*2);
        } else {
            int[][] choose = new int[][]{{1, 0}, {2, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}};
            for (int i = 0; i < toppingCosts.length; i++) {
                for (int j = i+1; j < toppingCosts.length; j++) {
                    for (int[] c : choose) {
                        top.add(c[0]*toppingCosts[i]+c[1]*toppingCosts[j]);
                    }
                }
            }
        }

        for (int b : baseCosts) {
            List<Integer> candidates = new ArrayList<>();
            if (b >= target) {
                candidates.add(b);
            } else {
                Integer l = top.lower(target-b);
                candidates.add(l+b);
                Integer r = top.ceiling(target-b);
                if (r != null) {
                    candidates.add(r+b);
                }
            }
            for (int p : candidates) {
                int d = Math.abs(p-target);
                if (d < diff) {
                    diff = d;
                    res = p;
                } else if (d == diff) {
                    res = Math.min(res, p);
                }
            }
        }
        return res;
    }
}
