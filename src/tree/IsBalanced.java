package tree;

/*110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：true*/
public class IsBalanced {//测试通过
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1;
    }
    public int depth(TreeNode root){
        return root==null?0:Math.max(depth(root.left),depth(root.right))+1;
    }
}
