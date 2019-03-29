import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0846HandStraights hands = new S0846HandStraights();
        StdOut.println(hands.isNStraightHand(new int[] {1, 1, 2, 2, 3, 3}, 3));
    }
}
