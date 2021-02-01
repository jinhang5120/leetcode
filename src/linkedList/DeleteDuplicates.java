package linkedList;

import tree.ListNode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode listNode = new DeleteDuplicates().deleteDuplicates(n1);

    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode tmp = root.next;
        boolean flag = true;
        while(tmp.next.val == root.next.val){
            tmp = tmp.next;
            flag = false;
        }
        if(!flag){
            root.next = tmp.next;
        }
        tmp = root;
        while(tmp.next!=null){
            ListNode tmp1 = tmp.next;
            flag = true;
            while(tmp1.next.val == tmp.next.val){
                tmp1 = tmp1.next;
                flag = false;
            }
            if(!flag){
                tmp.next = tmp1.next;
            }
            tmp = tmp.next;
        }
        return root.next;
    }
}
