package tree;
/*1367. 二叉树中的列表
给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。

如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。

一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。



示例 1：



输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true
解释：树中蓝色的节点构成了与链表对应的子路径。*/
public class IsSubPath {
    public boolean isSubPath(ListNode head, TreeNode root) {//测试通过，这里必须用两个递归，一个递归无法规避某些错误
        if(root==null) return false;
        return isSubPathFromRoot(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    public boolean isSubPathFromRoot(ListNode head,TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        if(root.val==head.val){
            return isSubPathFromRoot(head.next,root.left)||isSubPathFromRoot(head.next,root.right);
        }
        return false;
    }
}
