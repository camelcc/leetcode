import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0822CardFlippingGame game = new S0822CardFlippingGame();
        StdOut.println(game.flipgame(new int[] {1,2,4,4,7}, new int[]{1,3,4,1,3}));
    }
}
