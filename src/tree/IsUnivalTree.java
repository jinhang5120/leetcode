package tree;

/*965. 单值二叉树
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。



示例 1：



输入：[1,1,1,1,1,null,1]
输出：true*/
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {//测试通过
        return isUnival(root,root.val);
    }
    public boolean isUnival(TreeNode root,int val){
        if(root==null) return true;
        return root.val==val&&isUnival(root.left,val)&&isUnival(root.right,val);
    }
}
