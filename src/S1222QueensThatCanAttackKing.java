import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S1222QueensThatCanAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> queenPos = new HashSet<>();
        for (int[] queen: queens) {
            queenPos.add(queen[0]*8+queen[1]);
        }
        for (int[] dir : new int[][]{new int[]{0, -1},
                new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}, new int[]{0, 1},
                new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}}) {
            int r = king[0], c = king[1];
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                int pos = r * 8 + c;
                if (queenPos.contains(pos)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(r);
                    t.add(c);
                    res.add(t);
                    break;
                }

                r += dir[0];
                c += dir[1];
            }
        }
        return res;
    }
}
