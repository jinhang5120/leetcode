package concurrent;

import java.util.function.IntConsumer;
/*
* 1116. 打印零与奇偶数
假设有这么一个类：

class concurrent.ZeroEvenOdd {
  public concurrent.ZeroEvenOdd(int n) { ... }      // 构造函数
  public void zero(printNumber) { ... }  // 仅打印出 0
  public void even(printNumber) { ... }  // 仅打印出 偶数
  public void odd(printNumber) { ... }   // 仅打印出 奇数
}
相同的一个 concurrent.ZeroEvenOdd 类实例将会传递给三个不同的线程：

线程 A 将调用 zero()，它只输出 0 。
线程 B 将调用 even()，它只输出偶数。
线程 C 将调用 odd()，它只输出奇数。
每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。


* */
public class ZeroEvenOdd {//测试通过，外面现场只调用一次
    private int n;
    private volatile int flag = 0;
    private volatile int tmp = 0;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized(this){
                while(flag!=0){
                    wait();
                }
                printNumber.accept(0);
                if(tmp%2==0){
                    flag = 2;
                }else{
                    flag = 1;
                }
                tmp++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n/2;i++){
            synchronized(this){
                while(flag!=1){
                    wait();
                }
                printNumber.accept(tmp);
                flag = 0;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<(n+1)/2;i++){
            synchronized(this){
                while(flag!=2){
                    wait();
                }
                printNumber.accept(tmp);
                flag = 0;
                notifyAll();
            }
        }
    }
}