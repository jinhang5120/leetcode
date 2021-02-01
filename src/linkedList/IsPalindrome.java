package linkedList;

import tree.ListNode;
/*面试题 02.06. 回文链表
编写一个函数，检查输入的链表是否是回文的。



示例 1：

输入： 1->2
输出： false
示例 2：

输入： 1->2->2->1
输出： true */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {//测试通过
        //新思路：反转后半段前后两段比较是否一致，首先快慢指针找中点
        if(head==null) return true;
        ListNode tmp = head;
        int count = 1;
        while(tmp.next!=null){
            count++;
            tmp = tmp.next;
        }
        tmp.next = head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<count/2;i++){
            for(int j=0;j<count-1;j++){
                fast = fast.next;
            }
            if(slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
