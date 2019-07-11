import java.util.ArrayList;
import java.util.List;

public class S0989AddArrayFormInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int p = A.length-1;
        while (K > 0) {
            int d = K%10;
            if (p >= 0) {
                d += A[p];
                p--;
            }
            res.add(0, d%10);
            K = K/10 + d/10;
        }
        while (p >= 0) {
            res.add(0, A[p]);
            p--;
        }
        return res;
    }
}
