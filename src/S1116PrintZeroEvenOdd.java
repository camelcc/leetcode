import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class S1116PrintZeroEvenOdd {
    public static class ZeroEvenOdd {
        private int n;
        private Semaphore zero, even, odd;

        public ZeroEvenOdd(int n) {
            this.n = n;
            zero = new Semaphore(1);
            even = new Semaphore(0);
            odd = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (i%2 == 0) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i%2 != 0) {
                    continue;
                }
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i%2 == 0) {
                    continue;
                }
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
