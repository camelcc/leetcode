public class S1936AddMinimumNumberRungs {
    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int height = 0;
        for (int r : rungs) {
            if (r-height > dist) {
                res += (r-height-1)/dist;
            }
            height = r;
        }
        return res;
    }
}
