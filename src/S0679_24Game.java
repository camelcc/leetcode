import java.util.ArrayList;
import java.util.List;

public class S0679_24Game {
    public boolean judgePoint24(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2], d = nums[3];
        // 1-3
        for (int[] v : combs(new int[]{a, 1}, new int[]{24, 1})) {
            if (match(b, c, d, v[0], v[1])) {
                return true;
            }
        }
        for (int[] v : combs(new int[]{b, 1}, new int[]{24, 1})) {
            if (match(a, c, d, v[0], v[1])) {
                return true;
            }
        }
        for (int[] v : combs(new int[]{c, 1}, new int[]{24, 1})) {
            if (match(a, b, d, v[0], v[1])) {
                return true;
            }
        }
        for (int[] v : combs(new int[]{d, 1}, new int[]{24, 1})) {
            if (match(a, b, c, v[0], v[1])) {
                return true;
            }
        }

        // 2-2
        for (int[] v : combs(new int[]{a, 1}, new int[]{b, 1})) {
            for (int[] x : combs(new int[]{c, 1}, new int[]{d, 1})) {
                if (match(v, x, 24, 1)) {
                    return true;
                }
            }
        }
        for (int[] v : combs(new int[]{a, 1}, new int[]{c, 1})) {
            for (int[] x : combs(new int[]{b, 1}, new int[]{d, 1})) {
                if (match(v, x, 24, 1)) {
                    return true;
                }
            }
        }
        for (int[] v : combs(new int[]{a, 1}, new int[]{d, 1})) {
            for (int[] x : combs(new int[]{b, 1}, new int[]{c, 1})) {
                if (match(v, x, 24, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(int a, int b, int c, int num, int den) {
        for (int[] v : combs(new int[]{a, 1}, new int[]{b, 1})) {
            if (match(v, new int[]{c, 1}, num, den)) {
                return true;
            }
        }
        for (int[] v : combs(new int[]{a, 1}, new int[]{c, 1})) {
            if (match(v, new int[]{b, 1}, num, den)) {
                return true;
            }
        }
        for (int[] v : combs(new int[]{b, 1}, new int[]{c, 1})) {
            if (match(v, new int[]{a, 1}, num, den)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(int[] a, int[] b, int num, int den) {
        for (int[] v : combs(a, b)) {
            if (v[0] * den == v[1] * num) {
                return true;
            }
        }
        return false;
    }

    private List<int[]> combs(int[] a, int[] b) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{a[0] * b[1] + a[1] * b[0], a[1] * b[1]});
        res.add(new int[]{a[0] * b[0], a[1] * b[1]});
        res.add(new int[]{a[0] * b[1] - a[1] * b[0], a[1] * b[1]});
        res.add(new int[]{a[1] * b[0] - a[0] * b[1], a[1] * b[1]});
        if (a[1] != 0 && b[0] != 0) {
            res.add(new int[]{a[0] * b[1], a[1] * b[0]});
        }
        if (b[1] != 0 && a[0] != 0) {
            res.add(new int[]{a[1] * b[0], a[0] * b[1]});
        }
        return res;
    }
}
