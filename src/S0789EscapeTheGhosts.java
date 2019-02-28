public class S0789EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0])+Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int x = Math.abs(ghost[0]-target[0]);
            int y = Math.abs(ghost[1]-target[1]);
            if (x+y <= dis) {
                return false;
            }
        }
        return true;
    }
}
