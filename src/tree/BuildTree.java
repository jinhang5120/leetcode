package tree;

import java.util.Arrays;
/*剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7*/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {//测试通过
        if(preorder.length==0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        root.left = left;
        root.right = right;
        return root;
    }
}
