public class S1759CountNumberHomogenousSubstrings {
    public int countHomogenous(String s) {
        long res = 0;
        char p = '\0';
        long t = 0;
        for (char c : s.toCharArray()) {
            if (c != p) {
                res += t*(t+1)/2;
                t = 1;
                p = c;
            } else {
                t++;
            }
        }
        res += t*(t+1)/2;
        int MOD = 1_000_000_007;
        return (int)(res%MOD);
    }
}
