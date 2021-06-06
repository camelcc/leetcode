public class S1849SplittingStringIntoDescendingConsecutiveValues {
    public boolean splitString(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            long v = Long.parseLong(s.substring(0, i+1));
            if (v > Math.pow(10, s.length()-1-i)) {
                break;
            }
            if (dfs(s, i+1, v-1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, int p, long v) {
        if (v == 0) {
            for (int i = p; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        }
        for (int i = p; i < s.length(); i++) {
            long n = Long.parseLong(s.substring(p, i+1));
            if (n > v) {
                break;
            }
            if (n == v) {
                if (i+1 == s.length()) {
                    return true;
                }
                return dfs(s, i+1, v-1);
            }
        }
        return false;
    }
}
