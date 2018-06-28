import java.util.ArrayList;
import java.util.List;

public class S0089GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }

        List<Integer> codes = grayCode(n-1);
        res.addAll(codes);
        // reverse
        int pre = 0x1 << (n-1);
        for (int i = codes.size()-1; i >= 0; i--) {
            res.add(pre+codes.get(i));
        }
        return res;
    }
}
