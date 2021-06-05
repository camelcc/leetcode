import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class S1840MaximumBuildingHeight {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> outline = new LinkedList<>();
        int[] cur = new int[]{1, 0};
        for (int[] r : restrictions) {
            if (r[1] >= r[0]-cur[0]+cur[1]) {
                continue;
            }
            // visit back to remove outline
            while (!outline.isEmpty()) {
                int[] prev = outline.getLast();
                if (prev[1] >= r[1]+r[0]-prev[0]) {
                    outline.pollLast();
                } else {
                    break;
                }
            }
            outline.offer(r);
            cur = r;
        }
        cur = new int[]{1, 0};
        int res = 0;
        for (int[] r : outline) {
            int l = (r[0]+r[1]+cur[0]-cur[1])/2;
            res = Math.max(res, l-cur[0]+cur[1]);
            cur = r;
        }

        res = Math.max(res, n-cur[0]+cur[1]);
        return res;
    }
}
