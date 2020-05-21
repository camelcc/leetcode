import java.util.ArrayList;
import java.util.List;

public class S1447SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int den = 2; den <= n; den++) {
            for (int num = 1; num < den; num++) {
                if (gcd(num, den) == 1) {
                    res.add(String.format("%d/%d", num, den));
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
