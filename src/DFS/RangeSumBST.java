package DFS;

import tree.TreeNode;

/*
* 938. 二叉搜索树的范围和
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。



示例 1：


输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32
* */
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if(root==null) return res;
        if(low<=root.val&&root.val<=high){
            res+=root.val;
            res+=rangeSumBST(root.right,low,high);
            res+=rangeSumBST(root.left,low,high);
        }else if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }else if(high<root.val){
            return rangeSumBST(root.left,low,high);
        }
        return res;
    }
}
