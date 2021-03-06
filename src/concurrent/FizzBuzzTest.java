package concurrent;

import java.util.function.IntConsumer;
/*
* 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：

线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。

* */
public class FizzBuzzTest{//TODO 测试通过，各线程打印完要打印的东西后不能处于阻塞状态
    public static void main(String[] args) throws InterruptedException {

    }
}
class FizzBuzz {
    private int n;
    private int i = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i<=n){
            synchronized(this){
                if(i<=n){
                    while(i%3!=0||i%5==0){//只有3为假
                        wait();
                        if(i>n) return;//确保被唤醒后不处于阻塞状态
                    }
                    printFizz.run();
                    i++;
                    notifyAll();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i<=n){
            synchronized(this){
                if(i<=n){
                    while(i%5!=0||i%3==0){//只有5为假
                        wait();
                        if(i>n) return;
                    }
                    printBuzz.run();
                    i++;
                    notifyAll();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i<=n){
            synchronized(this){
                if(i<=n){
                    while(i%3!=0||i%5!=0){//只有15为假
                        wait();
                        if(i>n) return;
                    }
                    printFizzBuzz.run();
                    i++;
                    notifyAll();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i<=n){
            synchronized(this){
                if(i<=n){
                    while(i%3==0||i%5==0){//3，5，15为真
                        wait();
                        if(i>n) return;
                    }
                    printNumber.accept(i);
                    i++;
                    notifyAll();
                }
            }
        }
    }
}
