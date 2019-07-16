import java.util.Arrays;

public class S1012NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        if (digits.length == 1) {
            return 0;
        }
        int res = (int)Math.pow(10, digits.length-1)-1-nondup(digits.length-1);
        boolean[] exist = new boolean[10];
        for (int p = 0; p < digits.length; p++) {
            for (int d = (p == 0 ? 1 : 0); d < digits[p]-'0'; d++) {
                if (exist[d]) {
                    res += (int)Math.pow(10, digits.length-1-p);
                } else {
                    if (p < digits.length-1) {
                        res += (int)Math.pow(10, digits.length-1-p) -
                                nondup(digits.length-1-p, 9-p);
                    }
                }
            }
            if (exist[digits[p]-'0']) {
                if (p == digits.length-1) {
                    res++;
                } else {
                    res += Integer.valueOf(String.valueOf(
                            Arrays.copyOfRange(digits, p+1, digits.length)))+1;
                }
                break;
            }
            exist[digits[p]-'0'] = true;
        }

        return res;
    }

    private int nondup(int digits, int remains) {
        int nondup = 1;
        while (digits > 0) {
            nondup *= remains;
            remains--;
            digits--;
        }
        return nondup;
    }

    private int nondup(int digits) {
        int nondup = 9, remains = 9;
        int d = digits-1;
        while (d > 0) {
            nondup *= remains;
            d--;
            remains--;
        }
        return nondup + (digits == 1 ? 0 : nondup(digits-1));
    }
}
