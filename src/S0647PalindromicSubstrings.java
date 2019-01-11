public class S0647PalindromicSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] palindrom = new boolean[s.length()][s.length()];

        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                }

                if (start+1 <= end-1) {
                    if (palindrom[start+1][end-1]) {
                        palindrom[start][end] = true;
                        res++;
                    }
                } else {
                    palindrom[start][end] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
