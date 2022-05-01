public class S2259RemoveDigitFromNumberMaximizeResult {
    public String removeDigit(String number, char digit) {
        String res = null;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != digit) {
                continue;
            }
            String r = number.substring(0, i) + number.substring(i+1);
            if (res == null) {
                res = r;
            } else if (res.compareTo(r) < 0) {
                res = r;
            }
        }
        return res;
    }
}
