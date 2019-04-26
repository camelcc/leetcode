public class S0065ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        s = s.substring(i);

        int p = s.indexOf('e');
        if (p < 0) {
            return isDecimal(s);
        } else {
            String d1 = s.substring(0, p);
            String d2 = s.substring(p+1);
            if (!d2.isEmpty() && (d2.charAt(0) == '+' || d2.charAt(0) == '-')) {
                d2 = d2.substring(1);
            }
            if (d1.isEmpty() || d2.isEmpty()) {
                return false;
            }

            return isDecimal(d1) && isDigits(d2);
        }
    }

    private boolean isDecimal(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
            if (s.isEmpty()) {
                return false;
            }
        }

        int p = s.indexOf('.');
        if (p < 0) {
            return isDigits(s);
        } else {
            String d1 = s.substring(0, p);
            String d2 = s.substring(p+1);
            if (d1.isEmpty() && d2.isEmpty()) {
                return false;
            }
            return isDigits(d1) && isDigits(d2);
        }
    }

    private boolean isDigits(String s) {
        for (char d : s.toCharArray()) {
            if (!Character.isDigit(d)) {
                return false;
            }
        }
        return true;
    }
}
