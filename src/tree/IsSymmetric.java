package tree;

/*
* 剑指 Offer 28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3



示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
* */
public class IsSymmetric {//测试通过，只要是树的性质就递归
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return mirror(root.left,root.right);
        }
    }
    public boolean mirror(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }else if(root1!=null&&root2!=null){
            return root1.val==root2.val&&mirror(root1.left,root2.right)&&mirror(root1.right,root2.left);
        }else{
            return false;
        }
    }
}
