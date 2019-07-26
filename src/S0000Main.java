import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1117BuildingH2O.H2O h2O = new S1117BuildingH2O.H2O();
        int n = 20;
        Thread[] threads = new Thread[3*n];
        Runnable hydrogen = new Runnable() {
            @Override
            public void run() {
                StdOut.print("H");
            }
        };
        Runnable oxygen = new Runnable() {
            @Override
            public void run() {
                StdOut.print("O");
            }
        };
        int p = 0;
        for (int i = 0; i < n; i++) {
            threads[p++] = new Thread(()->{
                try {
                    h2O.hydrogen(hydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[p++] = new Thread(()->{
                try {
                    h2O.hydrogen(hydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[p++] = new Thread(()->{
                try {
                    h2O.oxygen(oxygen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
