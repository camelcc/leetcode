public class S1371FindLongestSubstringContainingVowelsEvenCounts {
    public int findTheLongestSubstring(String s) {
        int ca = 0, ce = 0, ci = 0, co = 0, cu = 0;
        int start = 0, end = 0;
        int res = 0;
        while (start < s.length() && s.length()-start > res) {
            int p = end, a = ca, e = ce, i = ci, o = co, u = cu;
            while (p < s.length()) {
                char c = s.charAt(p);
                if (c == 'a') {
                    a++;
                } else if (c == 'e') {
                    e++;
                } else if (c == 'i') {
                    i++;
                } else if (c == 'o') {
                    o++;
                } else if (c == 'u') {
                    u++;
                }
                if (a%2 == 0 && e%2 == 0 && i%2 == 0 && o%2 == 0 && u%2 == 0) {
                    ca = a;
                    ce = e;
                    ci = i;
                    co = o;
                    cu = u;
                    end = p+1;
                }
                p++;
            }
            res = Math.max(res, end-start);

            char c = s.charAt(start);
            if (c == 'a') {
                ca--;
            } else if (c == 'e') {
                ce--;
            } else if (c == 'i') {
                ci--;
            } else if (c == 'o') {
                co--;
            } else if (c == 'u') {
                cu--;
            }
            start++;
        }
        return res;
    }
}
