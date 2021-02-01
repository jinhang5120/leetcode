package design;

import java.util.Stack;
/*面试题 03.05. 栈排序
栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

示例1:

 输入：
["SortedStack", "push", "push", "peek", "pop", "peek"]
[[], [1], [2], [], [], []]
 输出：
[null,null,null,1,null,2]
示例2:

 输入：
["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
[[], [], [], [1], [], []]
 输出：
[null,null,null,null,null,true]*/
class SortedStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tmp = new Stack<>();
    public SortedStack() {//维持单调栈

    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
        }else{
            if(val<=stack.peek()){
                stack.push(val);
            }else{
                while(!stack.isEmpty()&&val>stack.peek()){
                    tmp.push(stack.pop());
                }
                stack.push(val);
                while(!tmp.isEmpty()){
                    stack.push(tmp.pop());
                }
            }
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int peek() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}