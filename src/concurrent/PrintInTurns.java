package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
* 三个不同的线程将会共用一个 concurrent.Foo 实例。

线程 A 将会调用 first() 方法
线程 B 将会调用 second() 方法
线程 C 将会调用 third() 方法
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

* */
public class PrintInTurns {
    public static void main(String[] args) throws InterruptedException {
//        concurrent.Foo foo = new concurrent.Foo();
//        Foo3 foo = new Foo3();
//        for (int i=0;i<10;i++) {
//            foo.first(() -> System.out.println(1));
//            foo.second(() -> System.out.println(2));
//            foo.third(() -> System.out.println(3));
//        }
        Semaphore semaphore = new Semaphore(1);
        int i = semaphore.availablePermits();
        System.out.println("i = " + i);
    }
}

class Foo {
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    volatile int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        while (flag != 1) {
            condition1.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
        condition2.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (flag != 2) {
            condition2.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
        condition3.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (flag != 3) {
            condition3.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        flag = 1;
        condition1.signal();
        lock.unlock();
    }
}

class Foo1 {
    volatile int flag = 1;

    public Foo1() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (flag != 1) {
            wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (flag != 2) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (flag != 3) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        flag = 1;
        notifyAll();
    }
}

class Foo2 {
    volatile int flag = 1;

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (flag != 1) {
                wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (flag != 2) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            notifyAll();
        }
    }
}
class Foo3 {
    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(1);
    Semaphore semaphore3 = new Semaphore(1);
    public Foo3() throws InterruptedException {
        semaphore2.acquire();
        semaphore3.acquire();
    }

    public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            semaphore1.acquire();
            printFirst.run();
            semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
            semaphore2.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
            semaphore3.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            semaphore1.release();
    }
}
