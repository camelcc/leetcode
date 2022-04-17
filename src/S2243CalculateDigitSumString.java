public class S2243CalculateDigitSumString {
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = 0, sum = 0;
            while (i+j < s.length() && j < k) {
                int d = s.charAt(i+j) - '0';
                sum += d;
                j++;
            }
            sb.append(String.valueOf(sum));
            i += k;
        }
        return digitSum(sb.toString(), k);
    }
}
