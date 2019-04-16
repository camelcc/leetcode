import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0886PossibleBipartition bipartition = new S0886PossibleBipartition();
        StdOut.println(bipartition.possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
    }
}
