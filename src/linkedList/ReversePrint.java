package linkedList;

import tree.ListNode;

/*剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]*/
public class ReversePrint {
    public int[] reversePrint(ListNode head) {//测试通过
        int count=0;
        ListNode tmp = head;
        while(tmp!=null){
            count++;
            tmp = tmp.next;
        }
        tmp = head;
        int[] res = new int[count];
        for(int i=0;i<res.length;i++){
            res[res.length-1-i] = head.val;
            head = head.next;
        }
        return res;
    }
}
