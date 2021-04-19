public class S1653MinimumDeletionsMakeStringBalanced {
    public int minimumDeletions(String s) {
        int a = 0, b = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                b++;
            }
        }
        int res = s.length();
        int ca = 0, cb = 0;
        for (char c : s.toCharArray()) {
            res = Math.min(res, cb + a-ca);
            if (c == 'a') {
                ca++;
            } else if (c == 'b') {
                cb++;
            }
        }
        res = Math.min(res, cb + a-ca);
        return res;
    }
}
