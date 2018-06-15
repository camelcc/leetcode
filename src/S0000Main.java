import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0475Heaters heaters = new S0475Heaters();
        int[] hourses = new int[] {1,1,1,1,1,1,999,999,999,999,999};
        int[] headers = new int[] {499,500,501};
        StdOut.println(heaters.findRadius(hourses, headers));
    }
}
