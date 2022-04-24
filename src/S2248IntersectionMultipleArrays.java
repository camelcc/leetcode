import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class S2248IntersectionMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        int M = nums.length;
        HashSet<Integer> current = new HashSet();
        for (int c = 0; c < nums[0].length; c++) {
            current.add(nums[0][c]);
        }
        for (int r = 1; r < M; r++) {
            HashSet<Integer> next = new HashSet();
            for (int c = 0; c < nums[r].length; c++) {
                if (current.contains(nums[r][c])) {
                    next.add(nums[r][c]);
                }
            }
            current = next;
            if (current.isEmpty()) {
                return new ArrayList();
            }
        }
        List<Integer> res = new ArrayList(current);
        Collections.sort(res);
        return res;
    }
}
