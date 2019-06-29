import java.util.ArrayList;
import java.util.List;

public class S0932BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> next = new ArrayList<>();
            for (int i : res) {
                if (2*i-1 <= N) {
                    next.add(2*i-1);
                }
            }
            for (int i : res) {
                if (2*i <= N) {
                    next.add(2*i);
                }
            }
            res = next;
        }
        int[] t = new int[N];
        for (int i = 0; i < N; i++) {
            t[i] = res.get(i);
        }
        return t;
    }
}
