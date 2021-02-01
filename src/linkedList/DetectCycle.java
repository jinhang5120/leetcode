package linkedList;

import tree.ListNode;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        ListNode listNode = new DetectCycle().detectCycle(n1);

    }
    public ListNode detectCycle(ListNode head) {
        //思路：
        //快慢指针，快指针每次向前走两步，慢指针每次向前走一步 #若有环，则快慢指针一定会相遇，且相遇时快指针多走的步数就是环的长度
        //当快慢指针相遇时，快指针比慢指针多走了环长度的整数倍，而且快指针比慢指针多走的和慢指针走的一样，所以慢指针走的步数也是环长度的整数倍！
        // 此时让快指针再从头走，速度和慢指针一样，两指针肯定会在环入口相遇
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                fast = head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
