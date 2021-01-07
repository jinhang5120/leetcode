package concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class SpingLock {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>(null);
    public void lock(){
        while(!atomicReference.compareAndSet(null,Thread.currentThread())){

        }
        System.out.println(Thread.currentThread().getName()+" get the lock");
    }
    public void unlock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName()+" unlock the lock");
    }

    public static void main(String[] args) {
        SpingLock lock = new SpingLock();
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("++++++++++++++");
            lock.unlock();
        }).start();
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------------");
            lock.unlock();
        }).start();
    }
}
