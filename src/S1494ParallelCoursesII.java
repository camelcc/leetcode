import javax.crypto.spec.PSource;
import java.util.*;

public class S1494ParallelCoursesII {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int END = 0;
        for (int i = 1; i <= n; i++) {
            END = END | (0x1 << i);
        }

        int[] pre = new int[n+1];
        for (int[] d : dependencies) {
            pre[d[1]] = pre[d[1]] | (0x1 << d[0]);
        }

        HashMap<Integer, Integer> dp = new HashMap<>();
        return min(n, pre, k, END, 0, dp);
    }

    private List<Integer> pick(int n, int[] pre, int finished, int k, int p) {
        List<Integer> res = new ArrayList<>();
        if (k == 1) {
            for (int i = p; i <= n; i++) {
                if (!finished(finished, i) && canTake(pre, finished, i)) {
                    res.add(finished | (0x1 << i));
                }
            }
            return res;
        }

        for (int i = p; i <= n; i++) {
            if (finished(finished, i) || !canTake(pre, finished, i)) {
                continue;
            }

            if (i == n) {
                res.add(finished | (0x1 << i));
            } else {
                int nf = finished | (0x1 << i);
                List<Integer> pi = pick(n, pre, finished, k-1, i+1);
                if (pi.isEmpty()) {
                    res.add(nf);
                } else {
                    for (int v : pi) {
                        res.add(nf | v);
                    }
                }
            }
        }
        return res;
    }

    private boolean finished(int finished, int course) {
        return (finished & (0x1 << course)) > 0;
    }

    private boolean canTake(int[] pre, int finished, int course) {
        return (pre[course] & finished) == pre[course];
    }

    private int min(int n, int[] pre, int k, int END, int finished, HashMap<Integer, Integer> dp) {
        if (finished == END) {
            return 0;
        }
        if (dp.containsKey(finished)) {
            return dp.get(finished);
        }

        int res = n;
        for (int p : pick(n, pre, finished, k, 1)) {
            res = Math.min(res, 1 + min(n, pre, k, END, p, dp));
        }
        dp.put(finished, res);
        return res;
    }
}
