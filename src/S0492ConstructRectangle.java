public class S0492ConstructRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (w > 1) {
            if (area % w == 0) {
                return new int[]{area/w, w};
            }
            w--;
        }
        return new int[]{area, 1};
    }
}
