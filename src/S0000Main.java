import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0913CatandMouse mouse = new S0913CatandMouse();
        StdOut.println(mouse.catMouseGame(new int[][]{{6},{4},{9},{5},{1,5},{3,4,6},{0,5,10},{8,9,10},{7},{2,7},{6,7}}));
    }
}
