import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0749ContainVirus virus = new S0749ContainVirus();
//        StdOut.println(virus.containVirus(new int[][]{{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}}));
        StdOut.println(virus.containVirus(new int[][]{{1,1,1,0,0,0,0,0,0},{1,0,1,0,1,1,1,1,1},{1,1,1,0,0,0,0,0,0}}));
    }
}
