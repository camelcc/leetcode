public class S1217PlayChips {
    public int minCostToMoveChips(int[] chips) {
        int oddCnt = 0, evenCnt = 0;
        for (int chip : chips) {
            if (chip%2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }
        return Math.min(oddCnt, evenCnt);
    }
}
