public class S0402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.isEmpty()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }

        String res = remove(num, k);
        while (res.startsWith("0")) {
            res = res.substring(1);
        }
        return res.isEmpty() ? "0" : res;
    }

    private String remove(String num, int k) {
        assert !num.isEmpty();
        assert k > 0;
        assert k < num.length();

        String res = "";
        for (char firstDigit = '0'; firstDigit <= '9'; firstDigit++) {
            int firstDigitIndex = num.indexOf(firstDigit);
            if (firstDigitIndex == -1) {
                continue;
            }

            if (firstDigitIndex <= k) {
                // remove all chars before index
                if (k-firstDigitIndex == 0) {
                    res = num.substring(firstDigitIndex);
                } else {
                    String remains = num.substring(firstDigitIndex + 1);
                    int remainsK = k - firstDigitIndex;
                    if (remains.length() == remainsK) {
                        res = String.valueOf(num.charAt(firstDigitIndex));
                    } else {
                        res = num.charAt(firstDigitIndex) + remove(remains, remainsK);
                    }
                }
                break;
            }
        }
        return res;
    }
}
