public class S0415AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int sup = 0;
        int s1index = num1.length()-1, s2index = num2.length()-1;
        while (s1index >= 0 || s2index >= 0) {
            int v1 = s1index >= 0 ? num1.charAt(s1index--) - '0' : 0;
            int v2 = s2index >= 0 ? num2.charAt(s2index--) - '0' : 0;
            int t = sup + v1 + v2;
            sup = t >= 10 ? t/10: 0;
            sum.insert(0, t%10);
        }
        if (sup > 0) {
            sum.insert(0, String.valueOf(sup));
        }
        return sum.toString();
    }
}
