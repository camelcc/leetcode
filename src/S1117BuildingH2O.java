import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class S1117BuildingH2O {
    public static class H2O {
        private Lock lock;
        // s -> o -> ho (h) -> start (h), s -> h -> hh -> s, s -> h -> ho -> s
        private int count;
        private Condition condition;

        public H2O() {
            lock = new ReentrantLock();
            count = 0;
            condition = lock.newCondition();
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            lock.lock();
            while (count == 2) {
                condition.await();
            }
            releaseHydrogen.run();
            count++;
            condition.signalAll();
            lock.unlock();

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            lock.lock();
            while (count != 2) {
                condition.await();
            }
            releaseOxygen.run();
            count = 0;
            condition.signalAll();
            lock.unlock();
        }
    }
}
