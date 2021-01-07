package concurrent;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    Semaphore[] forks = new Semaphore[] {
        new Semaphore(1),
        new Semaphore(0),
        new Semaphore(0),
        new Semaphore(0),
        new Semaphore(0)
    };
    public DiningPhilosophers() {//从0到4一个一个吃

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        forks[philosopher].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[(philosopher + 1) % 5].release();
    }
}
