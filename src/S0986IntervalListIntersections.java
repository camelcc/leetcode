import java.util.ArrayList;
import java.util.List;

public class S0986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int ai = 0, bi = 0;
        while (ai < A.length && bi < B.length) {
            if (A[ai][0] <= B[bi][0]) {
                if (A[ai][1] < B[bi][0]) {
                    ai++;
                    continue;
                }
                res.add(new int[]{B[bi][0], Math.min(A[ai][1], B[bi][1])});
            } else {
                if (B[bi][1] < A[ai][0]) {
                    bi++;
                    continue;
                }
                res.add(new int[]{A[ai][0], Math.min(A[ai][1], B[bi][1])});
            }

            if (A[ai][1] < B[bi][1]) {
                ai++;
            } else if (A[ai][1] == B[bi][1]) {
                ai++;
                bi++;
            } else { // A[ai][1] > B[bi][1]
                bi++;
            }
        }

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
