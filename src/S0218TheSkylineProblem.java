import java.util.*;

public class S0218TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length <= 0) {
            return new ArrayList<>();
        }

        Queue<int[]> current = new LinkedList<>();
        current.add(new int[]{buildings[0][0], buildings[0][2]});
        current.add(new int[]{buildings[0][1], 0});
        for (int i = 1; i < buildings.length; i++) {
            int l = buildings[i][0], r = buildings[i][1], h = buildings[i][2];
            Queue<int[]> next = new LinkedList<>();

            int[] last = new int[]{0, 0};
            while (!current.isEmpty()) {
                int[] t = current.peek();
                if (t[0] < l) {
                    next.add(current.poll());
                    last = t;
                } else {
                    break;
                }
            }

            if (!current.isEmpty()) {
                // consume head
                int[] c = current.poll();
                assert last[1] != c[1];
                if (c[0] == l) {
                    assert h >= c[1];
                    next.add(new int[]{l, h});
                    // consume end (r, h)
                    while (!current.isEmpty() && current.peek()[0] <= r) {
                        int[] t = current.poll();
                        if (t[0] == r) {
                            if (t[1] != h) {
                                next.add(t);
                            }
                        }
                    }

                    if (h <= c[1]) {
                        next.add(c);
                        last = c;
                    } else {
                        if (h != last[1]) {
                            last = new int[]{l, h};
                            next.add(last);
                        }
                    }
                } else {
                    assert c[0] > l;

                }


//                if (last == null || last[1] != h) {
//                    next.add(new int[]{l, h});
//                    next.add(new int[]{r, 0});
//                }
//                current = next;
//                continue;
            }

            if (current.peek()[0] == l) {
                int[] head = current.poll();
                next.add(new int[]{l, Math.max(head[1], h)});
            } else {

            }


        }



        List<List<Integer>> sky = new ArrayList<>();
        for (int[] r : res) {
            sky.add(conv(r));
        }
        return sky;
    }

    private List<Integer> conv(int[] point) {
        List<Integer> res = new ArrayList<>();
        res.add(point[0]);
        res.add(point[1]);
        return res;
    }
}
