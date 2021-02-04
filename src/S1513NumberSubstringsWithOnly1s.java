public class S1513NumberSubstringsWithOnly1s {
    public int numSub(String s) {
        int MOD = (int)Math.pow(10, 9) + 7;
        long res = 0;
        long cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                res += cnt * (cnt+1) / 2;
                cnt = 0;
            } else if (c == '1') {
                cnt++;
            }
        }
        res += cnt * (cnt+1) / 2;
        return (int)(res%MOD);
    }
}
