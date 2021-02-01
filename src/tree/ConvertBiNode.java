package tree;
/*面试题 17.12. BiNode
二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。

返回转换后的单向链表的头节点。

注意：本题相对原题稍作改动



示例：

输入： [4,2,5,1,3,null,6,0]
输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]*/
public class ConvertBiNode {
    public TreeNode convertBiNode(TreeNode root) {//测试通过
        if(root==null) return root;
        TreeNode left = convertBiNode(root.left);
        TreeNode right = convertBiNode(root.right);
        if(left!=null){
            TreeNode tmp = left;
            while(tmp.right!=null){
                tmp = tmp.right;
            }
            tmp.right = root;
            root.left = null;//不要忘记置空
            root.right = right;
            return left;
        }else{
            root.right = right;
            return root;
        }
    }
}
