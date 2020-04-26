import java.util.*;

public class S1424DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.isEmpty()) {
            return new int[0];
        }
        List<long[]> data = new ArrayList<>();
        long rowStart = 0;
        for (int r = 0; r < nums.size(); r++) {
            List<Integer> num = nums.get(r);
            long p = rowStart;
            int gap = 2+r;
            for (int n : num) {
                data.add(new long[]{n, p});
                p += gap++;
            }

            rowStart += (r+1);
        }
        data.sort(Comparator.comparingLong(o -> o[1]));
        int[] res = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            res[i] = (int)data.get(i)[0];
        }
        return res;
    }
}
