import java.util.HashMap;
import java.util.TreeSet;

public class S1027LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        int[][] len = new int[A.length][A.length];
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i]-A[j];
                int target = A[j]-diff;
                if (map.containsKey(target) && map.get(target).lower(j) != null) {
                    int p = map.get(target).lower(j);
                    len[i][j] = len[j][p] + 1;
                } else {
                    len[i][j] = 2;
                }
                res = Math.max(res, len[i][j]);
            }
            map.putIfAbsent(A[i], new TreeSet<>());
            map.get(A[i]).add(i);
        }
        return res;
    }
}
