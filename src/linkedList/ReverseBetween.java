package linkedList;

import tree.ListNode;
/*92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL*/
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {//测试通过，定位前驱节点以及要更改顺序的节点
        if(n==1) return head;
        ListNode root = new ListNode(0,head);
        ListNode pre = root;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode tmp = pre.next;
        for(int i=0;i<n-m;i++){
            ListNode tmp1 = tmp.next;
            tmp.next = tmp.next.next;
            tmp1.next = pre.next;
            pre.next = tmp1;
        }
        return root.next;
    }
}
