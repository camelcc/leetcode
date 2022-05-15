import java.util.Arrays;

public class S2274MaximumConsecutiveFloorsWithoutSpecialFloors {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int prev = bottom;
        int res = 0;
        for (int i = 0; i < special.length; i++) {
            if (special[i] == prev) {
                prev++;
                continue;
            }
            res = Math.max(res, special[i]-prev);
            prev = special[i]+1;
        }
        res = Math.max(res, top-prev+1);
        return res;
    }
}
