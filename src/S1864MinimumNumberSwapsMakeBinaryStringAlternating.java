public class S1864MinimumNumberSwapsMakeBinaryStringAlternating {
    public int minSwaps(String s) {
        int zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else if (c == '1') {
                one++;
            }
        }
        if (Math.abs(zero-one) > 1) {
            return -1;
        }
        if (zero > one) {
            return min(s, true);
        } else if (zero == one) {
            return Math.min(min(s, true), min(s, false));
        } else {
            return min(s, false);
        }
    }

    private int min(String s, boolean zero) {
        int diff = 0;
        for (char c : s.toCharArray()) {
            if (zero) {
                if (c == '1') {
                    diff++;
                }
            } else {
                if (c == '0') {
                    diff++;
                }
            }
            zero = !zero;
        }
        return diff/2;
    }
}
