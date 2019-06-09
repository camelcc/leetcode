public class S0008atoi {
    public int myAtoi(String str) {
        int res = 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return res;
        }
        int sign = 1;
        if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int d = str.charAt(i)-'0';
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && d > Integer.MAX_VALUE%10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + d;
            i++;
        }
        return res*sign;
    }
}
