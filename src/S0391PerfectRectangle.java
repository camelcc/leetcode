import java.util.*;

public class S0391PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length <= 1) {
            return true;
        }
        // bottom >> left >> top (reverse) >> right
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1]-o2[1];
                }
                if (o1[0] != o2[0]) {
                    return o1[0]-o2[0];
                }
                if (o1[3] != o2[3]) {
                    return o2[3]-o1[3];
                }
                return o1[2]-o2[2];
            }
        });

        LinkedList<int[]> segs = new LinkedList<>();
        for (int[] rec : rectangles) {
            // base
            if (rec[1] == rectangles[0][1]) {
                int[] last = segs.peekLast();
                if (last != null && last[1] != rec[0]) {
                    return false;
                }
                if (last != null && last[2] == rec[3]) {
                    segs.removeLast();
                    segs.add(new int[]{last[0], rec[2], rec[3]});
                } else {
                    segs.add(new int[]{rec[0], rec[2], rec[3]});
                }
                continue;
            }

            assert !segs.isEmpty();
            int left = segs.peekFirst()[0];
            int right = segs.peekLast()[1];
            if (rec[0] < left || rec[2] > right) {
                return false;
            }

            // not base
            LinkedList<int[]> next = new LinkedList<>();
            while (!segs.isEmpty()) {
                int[] seg = segs.poll();
                if (seg[1] <= rec[0] || seg[0] >= rec[2]) {
                    next.add(seg);
                    continue;
                }
                if (seg[2] != rec[1]) {
                    return false;
                }

                // start
                if (seg[0] <= rec[0] && seg[1] > rec[0]) {
                    // before
                    if (seg[0] < rec[0]) {
                        next.add(new int[]{seg[0], rec[0], seg[2]});
                    }

                    // mid
                    int[] last = next.peekLast();
                    if (last != null && last[2] == rec[3]) {
                        next.removeLast();
                        next.add(new int[]{last[0], Math.min(rec[2], seg[1]), rec[3]});
                    } else {
                        next.add(new int[]{rec[0], Math.min(rec[2], seg[1]), rec[3]});
                    }

                    // after
                    if (seg[1] > rec[2]) {
                        next.add(new int[]{rec[2], seg[1], seg[2]});
                    }
                    continue;
                }


                // mid
                if (seg[0] > rec[0] && seg[1] < rec[2]) {
                    int[] last = next.peekLast();
                    if (last != null && last[2] == rec[3]) {
                        next.removeLast();
                        next.add(new int[]{last[0], seg[1], rec[3]});
                    } else {
                        throw new IllegalStateException("invalid state");
                    }
                    continue;
                }

                // end
                if (seg[0] > rec[0] && seg[1] >= rec[2]) {
                    int[] last = next.peekLast();
                    if (last != null && last[2] == rec[3]) {
                        next.removeLast();
                        next.add(new int[]{last[0], Math.min(seg[1], rec[2]), rec[3]});
                    } else {
                        throw new IllegalStateException("invalid state");
                    }
                    if (seg[1] > rec[2]) {
                        next.add(new int[]{rec[2], seg[1], seg[2]});
                    }
                }
            }
            segs = next;
        }

        int[] last = segs.removeFirst();
        for (int[] seg : segs) {
            if (last[1] != seg[0] || last[2] != seg[2]) {
                return false;
            }

            last = seg;
        }

        return true;
    }
}
