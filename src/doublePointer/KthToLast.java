package doublePointer;


/*面试题 02.02. 返回倒数第 k 个节点
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4*/
public class KthToLast {
    public int kthToLast(ListNode head, int k) {//测试通过
        /*慢指针： 快指针先走k步，然后快慢指针同时往前走，直到快指针到结尾的时候，返回慢指针节点的值。*/
        ListNode slow = head;
        ListNode fast = head;
        while(k>1){
            fast = fast.next;
            k--;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
