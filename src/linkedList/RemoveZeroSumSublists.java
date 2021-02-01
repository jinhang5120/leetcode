package linkedList;

import tree.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveZeroSumSublists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(-3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = new RemoveZeroSumSublists().removeZeroSumSublists(n1);
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null) return null;
        List<Integer> list = new ArrayList<>();//前缀和
        ListNode tmp = head;
        int sum = 0;
        while(tmp!=null){
            sum+=tmp.val;
            list.add(sum);
            tmp = tmp.next;
        }
        int i=list.size()-1;
        while(i>=0){
            if(list.get(i)==0) break;
            i--;
        }
        if(i>=0){
            for(int j=0;j<i+1;j++){
                head = head.next;
            }
            return removeZeroSumSublists(head);
        }else{
            int j=0;
            int k=list.size()-1;
            boolean flag = true;
            while(j<list.size()-1){
                k=list.size()-1;
                while(k>j){
                    if(list.get(j)==list.get(k)){
                        flag = false;
                        break;
                    }
                    k--;
                }
                if(!flag) break;
                j++;
            }
            if(k>j){
                tmp = head;
                for(int h=0;h<j;h++){
                    tmp = tmp.next;
                }
                ListNode tmp1 = tmp;
                for(int h=0;h<k-j;h++){
                    tmp1 = tmp1.next;
                }
                tmp.next = tmp1.next;
                return removeZeroSumSublists(head);
            }else{
                return head;
            }
        }
    }
}
