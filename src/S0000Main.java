import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1172DinnerPlateStacks.DinnerPlates plates = new S1172DinnerPlateStacks.DinnerPlates(2);
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        StdOut.println(plates.popAtStack(0));
        plates.push(20);
        plates.push(21);
        StdOut.println(plates.popAtStack(0));
        StdOut.println(plates.popAtStack(2));
        StdOut.println(plates.pop());
        StdOut.println(plates.pop());
        StdOut.println(plates.pop());
        StdOut.println(plates.pop());
        StdOut.println(plates.pop());
    }
}
