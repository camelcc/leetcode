public class S2138DivideStringIntoGroupsSizeK {
    public String[] divideString(String s, int k, char fill) {
        int N = s.length();
        int n = (int)Math.ceil(N*1.0/k);
        String[] res = new String[n];
        int i = 0, r = 0;
        while (i < s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+k; j++) {
                sb.append(j >= s.length() ? fill : s.charAt(j));
            }
            i += k;
            res[r++] = sb.toString();
        }
        return res;
    }
}
