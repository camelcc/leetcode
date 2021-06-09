public class S1876SubstringsSizeThreeDistinctCharacters {
    public int countGoodSubstrings(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 2; i < c.length; i++) {
            if (c[i] == c[i-1] || c[i] == c[i-2] || c[i-1] == c[i-2]) {
                continue;
            }
            res++;
        }
        return res;
    }
}
