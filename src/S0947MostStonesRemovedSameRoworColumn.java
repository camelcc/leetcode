import java.util.HashMap;

public class S0947MostStonesRemovedSameRoworColumn {
    public int removeStones(int[][] stones) {
        int[] groups = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            groups[i] = i;
        }
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int rootx = x.containsKey(stones[i][0]) ? root(groups, x.get(stones[i][0])) : i;
            int rooty = y.containsKey(stones[i][1]) ? root(groups, y.get(stones[i][1])) : i;
            if (rootx != rooty) {
                groups[rooty] = rootx;
            }
            groups[i] = rootx;
            x.put(stones[i][0], rootx);
            y.put(stones[i][1], rootx);
        }
        int size = 0;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == i) {
                size++;
            }
        }
        return stones.length-size;
    }

    private int root(int[] groups, int i) {
        while (groups[i] != i) {
            i = groups[i];
        }
        return i;
    }
}
