import java.util.*;

public class S1326MinimumNumberTapsOpenWaterGarden {
    public int minTaps(int n, int[] ranges) {
        HashMap<Integer, Integer> max = new HashMap<>();
        TreeMap<Integer, Integer> taps = new TreeMap<>();
        max.put(0, 0);
        taps.put(0, 0);

        int[][] range = new int[ranges.length][2];
        for (int i = 0; i < range.length; i++) {
            range[i] = new int[]{i, ranges[i]};
        }
        Arrays.sort(range, (o1, o2) -> {
            if ((o1[0]-o1[1]) != (o2[0]-o2[1])) {
                return (o1[0]-o1[1])-(o2[0]-o2[1]);
            }
            return (o2[0]+o2[1])-(o1[0]+o1[1]);
        });

        for (int i = 0; i < range.length; i++) {
            if (range[i][1] == 0) {
                continue;
            }
            int left = range[i][0]-range[i][1];
            int right = range[i][0]+range[i][1];
            Integer end = taps.ceilingKey(left);
            if (end == null) {
                return -1;
            }
            while (end != null && end < right) {
                int c = taps.get(end);
                if (max.getOrDefault(c+1, 0) < right) {
                    max.put(c+1, right);
                    if (!taps.containsKey(right) || taps.get(right) > c+1) {
                        taps.put(right, c+1);
                    }
                }
                end = taps.higherKey(end);
            }
        }

        int res = -1;
        Integer end = taps.ceilingKey(n);
        while (end != null) {
            int r = taps.get(end);
            if (res == -1) {
                res = r;
            } else {
                res = Math.min(res, r);
            }
            end = taps.higherKey(end);
        }
        return res;
    }
}
