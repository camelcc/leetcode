public class S2139MinimumMovesReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                res += target-1;
                return res;
            }
            // maxDoubles > 0
            if (target%2 == 1) {
                target--;
                res++;
            }
            // target%2 == 0
            if (maxDoubles > 0) {
                target = target/2;
                maxDoubles--;
                res++;
            }
        }
        return res;
    }
}
