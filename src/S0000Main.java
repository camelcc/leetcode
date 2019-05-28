import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0770BasicCalculatorIV calculator = new S0770BasicCalculatorIV();
        StdOut.println(calculator.basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))", new String[] {}, new int[]{}));
    }
}
