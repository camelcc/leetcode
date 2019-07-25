import java.util.concurrent.Semaphore;

public class S1115PrintFooBarAlternately {
    class FooBar {
        private int n;
        private Semaphore semaphore;


        public FooBar(int n) {
            this.n = n;
            semaphore = new Semaphore(2*n);
            semaphore.drainPermits();
            semaphore.release();
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                int permits = 2*i+1;
                semaphore.acquire(permits);
                printFoo.run();
                semaphore.release(permits+1);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                int permits = 2*i+2;
                semaphore.acquire(permits);
                printBar.run();
                semaphore.release(permits+1);
            }
        }
    }
}
