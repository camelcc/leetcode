import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0312BurstBalloons balloons = new S0312BurstBalloons();
        StdOut.println(balloons.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
