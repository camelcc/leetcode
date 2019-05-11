import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0391PerfectRectangle rectangle = new S0391PerfectRectangle();
        StdOut.println(rectangle.isRectangleCover(new int[][]{
                {1,1,2,2},{0,1,1,2},{1,0,2,1},{0,2,3,3},{2,0,3,3}
        }));
//        StdOut.println(rectangle.isRectangleCover(new int[][]{
//                {0,0,4,1},
//                {7,0,8,2},
//                {6,2,8,3},
//                {5,1,6,3},
//                {4,0,5,1},
//                {6,0,7,2},
//                {4,2,5,3},
//                {2,1,4,3},
//                {0,1,2,2},
//                {0,2,2,3},
//                {4,1,5,2},
//                {5,0,6,1}}));
    }
}
