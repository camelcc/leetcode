import java.util.*;

public class S0218TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            points.add(new int[]{buildings[i][0], -buildings[i][2]});
            points.add(new int[]{buildings[i][1], buildings[i][2]});
        }
        points.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0]-o2[0];
                } else {
                    return o1[1]-o2[1];
                }
            }
        });
        Queue<Integer> maxH = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        maxH.add(0);
        int currentHeight = 0;
        for (int i = 0; i < points.size(); i++) {
            int[] point = points.get(i);
            if (point[1] < 0) {
                maxH.add(-point[1]);
            } else {
                maxH.remove(point[1]);
            }
            int h = maxH.peek();
            if (h != currentHeight) {
                List<Integer> t = new ArrayList<>();
                t.add(point[0]);
                t.add(h);
                res.add(t);
                currentHeight = h;
            }
        }
        return res;
    }
}
