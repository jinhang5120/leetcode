package linkedList;

import tree.ListNode;
/*面试题 02.04. 分割链表
编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。

示例:

输入: head = 3->5->8->5->10->2->1, x = 5
输出: 3->1->2->10->5->5->8*/
public class Partition {
    public ListNode partition(ListNode head, int x) {//测试通过
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode slow = root;
        ListNode fast = root;
        while(slow.next!=null&&slow.next.val<x){
            slow = slow.next;
            fast = fast.next;
        }
        while(true){
            while(fast.next!=null&&fast.next.val>=x){
                fast = fast.next;
            }
            ListNode tmp = fast.next;
            if(tmp!=null){
                fast.next = fast.next.next;
            }else{
                break;
            }
            tmp.next = slow.next;
            slow.next = tmp;
            slow = slow.next;
        }
        return root.next;
    }
}
