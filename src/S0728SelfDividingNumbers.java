import java.util.ArrayList;
import java.util.List;

public class S0728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean valid = true;

            boolean[] digits = new boolean[10];
            int t = i;
            while (t > 0) {
                int r = t%10;
                if (r == 0) {
                    valid = false;
                    break;
                }

                digits[r] = true;
                t = t/10;
            }
            for (int j = 1; j < 10; j++) {
                if (digits[j] && i%j != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                res.add(i);
            }
        }
        return res;
    }
}
