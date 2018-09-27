public class S0467UniqueSubstrings {
    public int findSubstringInWraproundString(String p) {
        int count[] = new int[26];
        int continous = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && ((p.charAt(i) - p.charAt(i-1)) == 1 || p.charAt(i-1) - p.charAt(i) == 25)) {
                continous++;
            } else {
                continous = 1;
            }

            char c = p.charAt(i);
            count[c - 'a'] = Math.max(count[c - 'a'], continous);
        }

        int res = 0;
        for (int i = 0 ; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }
}
