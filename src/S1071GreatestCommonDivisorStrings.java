public class S1071GreatestCommonDivisorStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }
        // 1.len >= 2.len
        if (!str1.startsWith(str2)) {
            return "";
        }
        int c = gcd(str1.length(), str2.length());
        return str1.substring(0, c);
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
