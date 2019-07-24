import java.util.concurrent.CountDownLatch;

public class S1114PrintOrder {
    class Foo {
        CountDownLatch second, third;

        public Foo() {
            second = new CountDownLatch(1);
            third = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.await();
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            printThird.run();
        }
    }
}
