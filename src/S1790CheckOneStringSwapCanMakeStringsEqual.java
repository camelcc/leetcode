public class S1790CheckOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        char d1 = '\0', d2 = '\0';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (diff >= 2) {
                return false;
            } else if (diff == 1) {
                if (d1 != s2.charAt(i) || d2 != s1.charAt(i)) {
                    return false;
                }
                diff++;
            } else {
                d1 = s1.charAt(i);
                d2 = s2.charAt(i);
                diff++;
            }
        }
        return diff != 1;
    }
}
