public class S0066PlusOne {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                c = 0;
                break;
            }
        }

        if (c == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
    }

}
