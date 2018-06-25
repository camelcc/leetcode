public class S0043MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String sum = "0";
        String zeros = "";
        for (int i = 0; i < num2.length(); i++) {
            String mul = multi(num1, getDigit(num2, i)) + zeros;
            sum = add(sum, mul);
            zeros = zeros + "0";
        }
        return sum;
    }

    private String multi(String num1, int m) {
        if (m == 0) {
            return "0";
        }

        StringBuilder mul = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length(); i++) {
            int s = getDigit(num1, i) * m + carry;
            mul.insert(0, String.valueOf(s%10));
            carry = s/10;
        }
        if (carry != 0) {
            mul.insert(0, String.valueOf(carry));
        }

        return mul.toString();
    }

    private String add(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }

        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int max = Math.max(num1.length(), num2.length());
        for (int i = 0; i < max; i++) {
            int s = carry + getDigit(num1, i) + getDigit(num2, i);
            sum.insert(0, String.valueOf(s%10));
            carry = s/10;
        }
        if (carry != 0) {
            sum.insert(0, String.valueOf(carry));
        }
        return sum.toString();
    }

    private int getDigit(String num, int d) {
        if (d >= num.length()) {
            return 0;
        }
        return num.charAt(num.length() - 1 - d) - '0';
    }
}
