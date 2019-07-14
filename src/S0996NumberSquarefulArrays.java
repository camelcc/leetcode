import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0996NumberSquarefulArrays {
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        return dfs(A, new boolean[A.length], 0, new ArrayList<>());
    }

    private int dfs(int[] A, boolean[] used, int cnt, List<Integer> path) {
        if (path.size() == A.length) {
            return cnt+1;
        }
        for (int i = 0; i < A.length; i++) {
            if (used[i] || (i > 0 && A[i] == A[i-1] && !used[i-1])) {
                continue;
            }
            if (path.isEmpty() || isSquare(path.get(path.size()-1)+A[i])) {
                used[i] = true;
                path.add(A[i]);
                cnt = dfs(A, used, cnt, path);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
        return cnt;
    }

    private boolean isSquare(int v) {
        int s = (int)Math.sqrt(v);
        return s*s == v;
    }
}
