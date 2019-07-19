public class S1037ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int ratioN = points[1][0]-points[0][0], ratioD = points[1][1]-points[0][1];
        return (points[2][0]-points[1][0])*ratioD != ratioN*(points[2][1]-points[1][1]);
    }
}
