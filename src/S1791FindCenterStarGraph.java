public class S1791FindCenterStarGraph {
    public int findCenter(int[][] edges) {
        int center1 = edges[0][0], center2 = edges[0][1];
        if (edges[1][0] == center1 || edges[1][0] == center2) {
            return edges[1][0];
        }
        if (edges[1][1] == center1 || edges[1][1] == center2) {
            return edges[1][1];
        }
        return -1;
    }
}
