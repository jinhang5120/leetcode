package design;
/*1381. 设计一个支持增量操作的栈
请你设计一个支持下述操作的栈。

实现自定义栈类 CustomStack ：

CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。*/
public class CustomStack {
    int[] arr = null;
    int i=0;
    public CustomStack(int maxSize) {//
        arr = new int[maxSize];
    }

    public void push(int x) {
        if(i<arr.length){
            arr[i] = x;
            i++;
        }
    }

    public int pop() {
        if(i>0){
            i--;
            return arr[i];
        }else{
            return -1;
        }
    }

    public void increment(int k, int val) {
        for(int j=0;j<k&&j<i;j++){
            arr[j]+=val;
        }
    }
}
