public class S0780ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                tx -= ((int)Math.max(1, (tx-sx)/ty))*ty;
            } else if (tx == ty) {
                return false;
            } else {
                ty -= ((int)Math.max(1, (ty-sy)/tx))*tx;
            }
        }
        return false;
    }
}
