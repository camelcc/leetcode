import java.util.ArrayList;
import java.util.List;

public class S1018BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < A.length; i++) {
            prev = (2*prev+A[i])%5;
            res.add(prev == 0);
        }
        return res;
    }
}
