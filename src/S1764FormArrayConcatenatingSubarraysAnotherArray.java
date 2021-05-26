import java.util.LinkedList;

public class S1764FormArrayConcatenatingSubarraysAnotherArray {
    public boolean canChoose(int[][] groups, int[] nums) {
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{0, 0});
        for (int i = 0; i < nums.length; i++) {
            LinkedList<int[]> next = new LinkedList<>();
            next.offer(new int[]{0, 0});
            for (int[] b : bfs) {
                if (groups[b[0]][b[1]] == nums[i]) {
                    if (b[1]+1 == groups[b[0]].length) {
                        if (b[0]+1 == groups.length) {
                            return true;
                        }
                        next.offer(new int[]{b[0]+1, 0});
                    } else {
                        next.offer(new int[]{b[0], b[1]+1});
                    }
                } else {
                    if (b[1] == 0) {
                        next.offer(b);
                    }
                }
            }
            bfs = next;
        }
        return false;
    }
}
