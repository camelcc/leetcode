import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1116PrintZeroEvenOdd.ZeroEvenOdd odd = new S1116PrintZeroEvenOdd.ZeroEvenOdd(2);
        new Thread(() -> {
            try {
                odd.odd(StdOut::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                odd.even(StdOut::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                odd.zero(StdOut::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
