public class S0541ReverseStringII {
    public String reverseStr(String s, int k) {
        if (k <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            // first half
            for (int j = i+k-1; j >= i; j--) {
                if (j >= s.length()) {
                    continue;
                }

                sb.append(s.charAt(j));
            }
            // second half
            for (int j = i+k; j < i + 2 * k; j++) {
                if (j >= s.length()) {
                    break;
                }

                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}
