import javafx.util.Pair;

import java.util.*;

public class S0365WaterJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0) {
            return z == 0 || z == y;
        }
        if (y == 0) {
            return z == 0 || z == x;
        }
        if (z > x + y) {
            return false;
        }
        if (z == x + y) {
            return true;
        }
        if (z % x == 0 || z % y == 0) {
            return true;
        }

        int gcd = gcd(x, y);
        return z%gcd == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        int r = x % y;
        return gcd(y, r);
    }

    public boolean _canMeasureWater(int x, int y, int z) {
        if (x == 0) {
            return z == 0 || z == y;
        }
        if (y == 0) {
            return z == 0 || z == x;
        }
        if (z > x + y) {
            return false;
        }
        if (z == x + y) {
            return true;
        }
        if (z % x == 0 || z % y == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> states = new HashMap<>();
        List<Pair<Integer, Integer>> queue = new ArrayList<>();
        queue.add(new Pair<>(0, 0));
        // run machine
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> q = queue.remove(queue.size()-1);
            int tx = q.getKey();
            int ty = q.getValue();

            if (states.containsKey(tx) && states.get(tx).contains(ty)) {
                continue;
            }
            if (states.containsKey(tx)) {
                states.get(tx).add(ty);
            } else {
                HashSet<Integer> t = new HashSet<>();
                t.add(ty);
                states.put(tx, t);
            }

            // fill x
            if (tx < x) {
                if (x == z || ty == z || ty + x == z) {
                    return true;
                }

                queue.add(new Pair<>(x, ty));
            }
            // fill y
            if (ty < y) {
                if (tx == z || y == z || tx + y == z) {
                    return true;
                }

                queue.add(new Pair<>(tx, y));
            }
            // empty x
            if (tx > 0) {
                if (ty == z) {
                    return true;
                }

                queue.add(new Pair<>(0, ty));
            }
            // empty y
            if (ty > 0) {
                if (tx == z) {
                    return true;
                }

                queue.add(new Pair<>(tx, 0));
            }
            // pour x->y
            if (tx > 0) {
                if (tx >= y - ty) {
                    // full y
                    if ((tx - (y - ty)) == z || y == z || tx + ty == z) {
                        return true;
                    }

                    queue.add(new Pair<>(tx - (y - ty), y));
                } else {
                    // empty x
                    if (tx + ty == z) {
                        return true;
                    }
                    queue.add(new Pair<>(0, tx+ty));
                }
            }
            // pour y->x
            if (ty > 0) {
                if (ty >= x - tx) {
                    // full x
                    if (x == z || (ty - (x - tx)) == z || tx + ty == z) {
                        return true;
                    }
                    queue.add(new Pair<>(x, ty - (x - tx)));
                } else {
                    // empty y
                    if (tx + ty == z) {
                        return true;
                    }
                    queue.add(new Pair<>(tx+ty, 0));
                }
            }
        }
        return false;
    }
}
