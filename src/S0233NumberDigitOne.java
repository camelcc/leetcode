import java.util.HashMap;

public class S0233NumberDigitOne {
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int digit = 1;
        int v = n;
        while (v >= 10) {
            v = v/10;
            digit++;
        }
        int res = 0;
        for (int i = 0; i < v; i++) {
            res += count(digit-1);
        }

        int remains = n-(int)(v*Math.pow(10, digit-1));
        res += countDigitOne(remains);


        if (v != 1) {
            res += (int)(Math.pow(10, digit-1));
        } else {
            res += remains+1;
        }
        return res;
    }

    private int count(int digits) {
        if (dp.containsKey(digits)) {
            return dp.get(digits);
        }

        if (digits == 1) {
            dp.put(digits, 1);
            return 1;
        }

        int res = 10*count(digits-1)+(int)(Math.pow(10, digits-1));
        dp.put(digits, res);
        return res;
    }
}
