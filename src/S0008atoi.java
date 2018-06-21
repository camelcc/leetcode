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
        boolean positive = true;
        char first = str.charAt(i);
        if (first == '-') {
            positive = false;
            i++;
        } else if (first == '+') {
            i++;
        } else if (first >= '0' && first <= '9') {

        } else {
            return res;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int d = c-'0';
                if (positive) {
                    if ((Integer.MAX_VALUE - d)/10 < res) {
                        return Integer.MAX_VALUE;
                    }

                    res = res * 10 + d;
                } else {
                    if ((Integer.MIN_VALUE + d)/10 > res) {
                        return Integer.MIN_VALUE;
                    }

                    res = res * 10 - d;
                }
            } else {
                break;
            }
        }
        return res;
    }
}
