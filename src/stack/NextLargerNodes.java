package stack;

import tree.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*1019. 链表中的下一个更大节点
给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。

每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。

返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。

注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。*/
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {//测试通过，因为要找最近最大的，所以用单调栈，只要是涉及最近的就用栈
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        Stack<Integer> monoStack = new Stack<>();
        int[] res = new int[list.size()];
        monoStack.push(list.get(list.size()-1));
        for(int i=list.size()-2;i>=0;i--){
            while(!monoStack.isEmpty()&&list.get(i)>=monoStack.peek()){
                monoStack.pop();
            }
            if(monoStack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = monoStack.peek();
            }
            monoStack.push(list.get(i));
        }
        return res;
    }
}
