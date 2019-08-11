public class S0066PlusOne {
    public int[] plusOne(int[] digits) {
        int pos = digits.length-1, carry = 1;
        while (carry != 0) {
            if (pos < 0) {
                int[] res = new int[digits.length+1];
                res[0] = carry;
                for (int i = 0; i < digits.length; i++) {
                    res[i+1] = digits[i];
                }
                return res;
            }

            int t = digits[pos]+carry;
            digits[pos] = t%10;
            carry = t/10;
            pos--;
        }
        return digits;
    }

}
