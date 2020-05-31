import java.util.Arrays;

public class S1465MaximumAreaPieceCakeAfterHorizontalVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long res = 0;

        int hmax = 0;
        int hprev = 0;
        for (int hi = 0; hi <= horizontalCuts.length; hi++) {
            int hcurrent = (hi == horizontalCuts.length ? h : horizontalCuts[hi]);
            hmax = Math.max(hmax, hcurrent-hprev);
            hprev = hcurrent;
        }
        int vmax = 0;
        int vprev = 0;
        for (int vi = 0; vi <= verticalCuts.length; vi++) {
            int vcurrent = (vi == verticalCuts.length ? w : verticalCuts[vi]);
            vmax = Math.max(vmax, vcurrent-vprev);
            vprev = vcurrent;
        }
        int MOD = (int)(Math.pow(10, 9)+7);
        long area = hmax;
        area = area * vmax;
        return (int)(area%MOD);
    }
}
