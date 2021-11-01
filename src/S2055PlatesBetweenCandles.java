public class S2055PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] pre = new int[s.length()];
        int[] post = new int[s.length()];
        int i = 0, c = 0, p = 0;
        int total = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != '|') {
                i++;
                c++;
            }
            while (p < s.length() && p <= i) {
                pre[p] = c;
                p++;
            }
            i++;
        }
        total = c;
        i = s.length()-1;
        c = 0;
        p = s.length()-1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != '|') {
                i--;
                c++;
            }
            while (p >= 0 && p >= i) {
                post[p] = c;
                p--;
            }
            i--;
        }
        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            res[j] = Math.max(0, total-pre[queries[j][0]]-post[queries[j][1]]);
        }
        return res;
    }
}
