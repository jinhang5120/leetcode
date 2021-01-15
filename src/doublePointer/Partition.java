package doublePointer;
/*86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。



示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5*/
public class Partition {
    public static void main(String[] args) {//测试通过
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n5.next=n5;
        ListNode partition = new Partition().partition(n1, 3);
        System.out.println("partition = " + partition);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0,head);
        ListNode res = root;
        while(root.next!=null&&root.next.val<x){
            root = root.next;
        }
        ListNode slow = root;
        ListNode fast = root;
        while(fast.next!=null){
            while(fast.next!=null&&fast.next.val>=x){
                fast = fast.next;
            }
            if(fast.next!=null){
                ListNode tmp1 = slow.next;
                ListNode tmp2 = fast.next.next;
                slow.next = fast.next;
                slow.next.next = tmp1;
                fast.next = tmp2;
                slow = slow.next;
            }
        }
        return res.next;
    }
}
