public class S1732FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int res = 0, alt = 0;
        for (int g : gain) {
            alt += g;
            res = Math.max(res, alt);
        }
        return res;
    }
}
