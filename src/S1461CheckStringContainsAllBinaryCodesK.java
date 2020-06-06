public class S1461CheckStringContainsAllBinaryCodesK {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int max = 0x1<<k;
        int mask = max-1;

        boolean[] matched = new boolean[max];
        int v = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i < k) {
                v = (v << 1) + (c == '1' ? 1 : 0);
            } else {
                matched[v] = true;
                v = ((v << 1) & mask) + (c == '1' ? 1 : 0);
            }
            i++;
        }
        matched[v] = true;

        for (int j = 0; j < matched.length; j++) {
            if (!matched[j]) {
                return false;
            }
        }
        return true;
    }
}
