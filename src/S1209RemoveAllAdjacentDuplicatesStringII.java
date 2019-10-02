public class S1209RemoveAllAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {
        String res = s;
        boolean dedup = false;
        do {
            StringBuilder sb = new StringBuilder();
            dedup = dedup(res, k, sb);
            res = sb.toString();
        } while (dedup);
        return res;
    }

    private boolean dedup(String s, int k, StringBuilder sb) {
        assert k >= 2;
        int pos = 0, de = 0;
        StringBuilder current = new StringBuilder();
        char last = '\0';
        while (pos < s.length()) {
            char c = s.charAt(pos);

            // k >= 2
            if (c == last) {
                current.append(c);
                if (current.length() == k) {
                    current = new StringBuilder();
                    de++;
                    last = sb.length() == 0 ? '\0' : sb.charAt(sb.length()-1);
                }
            } else {
                sb.append(current);
                current = new StringBuilder();
                current.append(c);
                last = c;
            }

            pos++;
        }
        if (current.length() > 0) {
            sb.append(current);
        }
        return de > 0;
    }
}
