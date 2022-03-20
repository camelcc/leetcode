public class S2212MaximumPointsArcheryCompetition {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] res = new int[12];
        int point = 0;

        for (int i = 0; i < (0x1<<12)-1; i++) {
            int a = numArrows;
            int p = 0;
            int[] r = new int[12];
            for (int j = 0; j < 12; j++) {
                if ((i&(0x1<<j)) == 0) {
                    continue;
                }
                r[j] = aliceArrows[j]+1;
                a -= r[j];
                p += j;
                if (a < 0) {
                    break;
                }
            }
            if (a < 0 || p <= point) {
                continue;
            }
            r[0] += a;
            res = r;
            point = p;
        }
        return res;
    }
}
