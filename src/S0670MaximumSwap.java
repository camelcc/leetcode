import java.util.ArrayList;
import java.util.List;

public class S0670MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> t = new ArrayList<>();
        int n = num;
        while (n != 0) {
            t.add(0, n%10);
            n = n/10;
        }
        int[] digits = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            digits[i] = t.get(i);
        }

        int[] max = new int[digits.length];
        max[digits.length-1] = digits.length-1;
        for (int i = digits.length-2; i >= 0; i--) {
            if (digits[i] >= digits[max[i+1]]) {
                max[i] = i;
            } else {
                max[i] = max[i+1];
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if (max[i] == i) {
                continue;
            }

            int td = digits[max[i]];
            int ti = max[i];
            for (int j = max[i]; j < digits.length; j++) {
                if (digits[j] == td) {
                    ti = j;
                }
            }

            digits[ti] = digits[i];
            digits[i] = td;
            break;
        }

        int res = 0;
        for (int i = 0; i < digits.length; i++) {
            res = 10*res + digits[i];
        }
        return res;
    }
}
