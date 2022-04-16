public class S2240NumberWaysBuyPensPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int pen = 0; pen <= total/cost1; pen++) {
            res += (total-(long)pen*cost1)/cost2 + 1;
        }
        return res;
    }
}
