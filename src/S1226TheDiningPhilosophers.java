import java.util.concurrent.Semaphore;

public class S1226TheDiningPhilosophers {
    class DiningPhilosophers {
        private Semaphore[] forks;

        public DiningPhilosophers() {
            forks = new Semaphore[5];
            for (int i = 0; i < 5; i++) {
                forks[i] = new Semaphore(1, true);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            if (philosopher == 0) {
                forks[4].acquire();
                pickRightFork.run();
                forks[0].acquire();
                pickLeftFork.run();
            } else {
                forks[philosopher].acquire();
                pickLeftFork.run();
                forks[philosopher-1].acquire();
                pickRightFork.run();
            }
            eat.run();
            if (philosopher == 0) {
                putLeftFork.run();
                forks[0].release();
                putRightFork.run();
                forks[4].release();
            } else {
                putRightFork.run();
                forks[philosopher-1].release();
                putLeftFork.run();
                forks[philosopher].release();
            }
        }
    }
}
