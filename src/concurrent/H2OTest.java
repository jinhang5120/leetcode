package concurrent;

import java.util.concurrent.Semaphore;

public class H2OTest {
    public static void main(String[] args) throws InterruptedException {
        H201 h2O = new H201();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    h2O.oxygen(() -> {
                        System.out.println("O");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.println("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class H20 {
    public H20() {}

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
class H201 {
    public H201() {}
    private int h = 0;
    private int o = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this){
            while(h==2){
                wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h++;
            if(h==2){
                o=0;
            }
            notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (o==1){
                wait();
            }
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            o++;
            h=0;
            notifyAll();
        }
    }
}