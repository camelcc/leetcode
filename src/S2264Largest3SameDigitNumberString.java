public class S2264Largest3SameDigitNumberString {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length()-2; i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                String r = num.substring(i, i+3);
                if (res.equals("") || res.compareTo(r) < 0) {
                    res = r;
                }
            }
        }
        return res;
    }
}
