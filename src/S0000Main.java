import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0909SnakesandLadders ladders = new S0909SnakesandLadders();
        StdOut.println(ladders.snakesAndLadders(new int[][]{{-1,-1,30,14,15,-1},{23,9,-1,-1,-1,9},{12,5,7,24,-1,30},{10,-1,-1,-1,25,17},{32,-1,28,-1,-1,32},{-1,-1,23,-1,13,19}}));
    }
}
