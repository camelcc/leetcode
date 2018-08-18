import java.util.ArrayList;
import java.util.List;

public class S0386LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 10) {
            for (int i = 1; i <= n; i++) {
                res.add(i);
            }
            return res;
        }

        // n >= 10, d >= 2
        int d = (int)(Math.log10(n) + 1);
        int max = (int)Math.pow(10, d) - 1;
        int firstDigit = n/((max+1)/10);
        if (firstDigit == 9 && n/10 == max/10) {
            max = n;
        } else {
            max = max/10;
        }

        // 1 ~ max
        int i = 1;
        while (i != max) {
            res.add(i);
            i = inc(i, n);
        }
        res.add(i);
        return res;
    }

    private int inc(int num, int max) {
        if (num * 10 <= max) {
            return num * 10;
        }

        if (num >= max) {
            num = num/10;
        }
        int v = num+1;
        while (v%10 == 0) {
            v = v/10;
        }
        return v;
    }
}
